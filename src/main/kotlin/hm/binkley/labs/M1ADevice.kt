package hm.binkley.labs

class M1ADevice(
    private val serialNo: String,
) : M1Device<M1ADevice> {
    fun runName(c: M1NameCommand) = 2 * c.name.length

    override fun toString() = "M1-A/$serialNo"
}
