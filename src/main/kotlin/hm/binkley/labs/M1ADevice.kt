package hm.binkley.labs

class M1ADevice(
    private val serialNo: String,
) : M1Device<M1ADevice> {
    @Suppress("UNUSED_PARAMETER")
    fun runName(c: M1NameCommand) = true

    override fun toString() = "M1-A/$serialNo"
}
