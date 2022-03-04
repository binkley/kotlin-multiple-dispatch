package hm.binkley.labs

import hm.binkley.labs.command.M1NameCommand
import hm.binkley.labs.command.M2NameCommand
import hm.binkley.labs.command.ResetCommand
import hm.binkley.labs.command.TimeCommand
import hm.binkley.labs.command.TimeResponse
import hm.binkley.labs.command.sendReset
import hm.binkley.labs.device.M1ADevice
import hm.binkley.labs.device.M1BDevice
import hm.binkley.labs.device.M2Device

fun runDemoWithMap() {
    registerAll()

    for (
        device in listOf(
            m1aDevice,
            m1bDevice,
            m2Device
        )
    ) for (
        command in listOf(
            ResetCommand,
            timeCommand,
            m1NameCommand,
            m2NameCommand
        )
    ) device.demoWithMap(command)

    println()

    // Example of handling specific response type
    val timeResponse: TimeResponse = m1aDevice.sendWithMap(timeCommand)
    println("$timeResponse <- ${timeCommand::class.simpleName} sent to $m1aDevice")
}

private fun Device<*>.demoWithMap(command: Command<*, *>) = try {
    val result = this.sendWithMap<Any>(command)
    println("$result <- ${command::class.simpleName} sent to $this")
} catch (e: MissingMethodException) {
    println("BUG: ${e.message}")
}

private fun registerAll() {
    // Reset command is common to all
    register { _: M1ADevice, _: ResetCommand -> sendReset() }
    register { _: M1BDevice, _: ResetCommand -> sendReset() }
    register { _: M2Device, _: ResetCommand -> sendReset() }
    // Time command varies by device
    register { d: M1ADevice, c: TimeCommand -> d.sendTimeToM1(c) }
    register { d: M1BDevice, c: TimeCommand -> d.sendTimeToM1(c) }
    register { d: M2Device, c: TimeCommand -> d.sendTimeToM2(c) }
    // Name command has different versions
    // No v2 name command defined for the M1 devices
    register { d: M1ADevice, c: M1NameCommand -> d.sendName1ToM1A(c) }
    register { d: M1BDevice, c: M1NameCommand -> d.sendName1ToM1B(c) }
    register { d: M2Device, c: M1NameCommand -> d.sendName1ToM2(c) }
    register { d: M2Device, c: M2NameCommand -> d.sendName2ToM2(c) }
}
