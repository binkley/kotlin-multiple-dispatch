package hm.binkley.labs

class M1BDevice(
    private val serialNo: String,
) : M1Device<M1BDevice> {
    @Suppress("UNUSED_PARAMETER")
    fun runName(c: M1NameCommand) = false

    override fun toString() = "M1-B/$serialNo"
}
