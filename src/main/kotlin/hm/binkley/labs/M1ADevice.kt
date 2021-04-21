package hm.binkley.labs

data class M1ADevice(
    private val serialNo: Long,
) : M1Device<M1ADevice> {
    fun runName(c: M1NameCommand) = 2 * c.name.length

    override fun toString() = "M1-A/$serialNo"
}
