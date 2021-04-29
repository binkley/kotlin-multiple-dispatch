package hm.binkley.labs.device

import hm.binkley.labs.command.M1NameCommand

class M1ADevice(
    private val serialNo: String,
) : M1Device<M1ADevice> {
    fun sendName1ToM1A(c: M1NameCommand) = c.name.isNotEmpty()

    override fun toString() = "M1-A/$serialNo"
}
