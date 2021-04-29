package hm.binkley.labs.device

import hm.binkley.labs.command.M1NameCommand

class M1BDevice(
    private val serialNo: String,
) : M1Device<M1BDevice> {
    fun sendName1ToM1B(c: M1NameCommand) = c.name.isEmpty()

    override fun toString() = "M1-B/$serialNo"
}
