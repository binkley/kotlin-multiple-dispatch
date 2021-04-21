package hm.binkley.labs

private val m1aDevice = M1ADevice(123L)
private val m1bDevice = M1BDevice(456L)
private val m2Device = M2Device(456L, "SG")

private val timeCommand = TimeCommand(1L)
private val m1NameCommand = M1NameCommand("BOB")
private val m2NameCommand = M2NameCommand("BOB", "NANCY")

fun main() {
    registerAll()

    demo(m1aDevice, ResetCommand)
    demo(m1aDevice, timeCommand)
    demo(m1aDevice, m1NameCommand)
    demo(m1aDevice, m2NameCommand)

    demo(m1bDevice, ResetCommand)
    demo(m1bDevice, timeCommand)
    demo(m1bDevice, m1NameCommand)
    demo(m1bDevice, m2NameCommand)

    demo(m2Device, ResetCommand)
    demo(m2Device, timeCommand)
    demo(m2Device, m1NameCommand)
    demo(m2Device, m2NameCommand)
}

private inline fun <reified D : Device<D>, reified C : Command<C>> demo(
    device: D,
    command: C,
) {
    try {
        val result = dispatch(device, command)
        println("$result <- ${command::class.simpleName} sent to $device")
    } catch (e: MissingMethodException) {
        println("BUG: ${e.message}")
    }
}
