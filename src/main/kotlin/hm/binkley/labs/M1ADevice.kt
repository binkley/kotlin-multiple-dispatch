package hm.binkley.labs

class M1ADevice(
    private val serialNo: String,
) : M1Device<M1ADevice> {
    fun sendName1ToM1A(c: M1NameCommand) = c.name.isNotEmpty()

    override fun toString() = "M1-A/$serialNo"
}
