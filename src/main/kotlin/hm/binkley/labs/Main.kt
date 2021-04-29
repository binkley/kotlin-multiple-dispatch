package hm.binkley.labs

private val m1aDevice = M1ADevice("1-2-3")
private val m1bDevice = M1BDevice("4-5-6")
private val m2Device = M2Device("7-8-9-0", "SG")

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
    ) for (
        command in listOf(
            ResetCommand,
            timeCommand,
            m1NameCommand,
            m2NameCommand
        )
    ) device.demo(command)
}

private fun Device<*>.demo(command: Command<*, *>) = try {
    val result = this.dispatch<Any>(command)
    println("$result <- ${command::class.simpleName} sent to $this")
} catch (e: MissingMethodException) {
    println("BUG: ${e.message}")
}
