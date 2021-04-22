package hm.binkley.labs

private val m1aDevice = M1ADevice(123L)
private val m1bDevice = M1BDevice(456L)
private val m2Device = M2Device(456L, "SG")

private val timeCommand = TimeCommand(1L)
private val m1NameCommand = M1NameCommand("BOB")
private val m2NameCommand = M2NameCommand("BOB", "NANCY")

fun main() {
    registerAll()

    for (
        device in listOf(
            m1aDevice,
            m1bDevice,
            m2Device
        )
    )
        for (
            command in listOf(
                ResetCommand,
                timeCommand,
                m1NameCommand,
                m2NameCommand
            )
        )
            demo(device, command)
}

private fun demo(device: Device<*>, command: Command<*>) = try {
    val result = dispatch(device, command)
    println("$result <- ${command::class.simpleName} sent to $device")
} catch (e: MissingMethodException) {
    println("BUG: ${e.message}")
}
