package hm.binkley.labs

import hm.binkley.labs.command.M1NameCommand
import hm.binkley.labs.command.M2NameCommand
import hm.binkley.labs.command.TimeCommand
import hm.binkley.labs.device.M1ADevice
import hm.binkley.labs.device.M1BDevice
import hm.binkley.labs.device.M2Device

val m1aDevice = M1ADevice("1-2-3")
val m1bDevice = M1BDevice("4-5-6")
val m2Device = M2Device("7-8-9-0", "SG")

val timeCommand = TimeCommand(1L)
val m1NameCommand = M1NameCommand("BOB")
val m2NameCommand = M2NameCommand("BOB", "NANCY")

fun main() {
    println("== DEMO WITH MAP")
    runDemoWithMap()

    println()
    println("== DEMO WITH CONTEXT")
    runDemoWithContext()
}
