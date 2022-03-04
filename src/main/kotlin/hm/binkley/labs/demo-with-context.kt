package hm.binkley.labs

import hm.binkley.labs.command.ResetCommand
import hm.binkley.labs.command.TimeResponse

fun runDemoWithContext() {
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
    ) device.demoWithContext(command)

    println()

    // Example of handling specific response type -- see map demo
    // Example of handling specific response type
    val timeResponse: TimeResponse = m1aDevice.sendWithContext(timeCommand)
    println("$timeResponse <- ${timeCommand::class.simpleName} sent to $m1aDevice")
}

private fun Device<*>.demoWithContext(command: Command<*, *>) {
    val result = this.sendWithContext<Any>(command)
    println("$result <- ${command::class.simpleName} sent to $this")
}
