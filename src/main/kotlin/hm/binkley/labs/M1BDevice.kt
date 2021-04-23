package hm.binkley.labs

data class M1BDevice(
    private val serialNo: String,
) : M1Device<M1BDevice> {
    fun runName(c: M1NameCommand) = 3 * c.name.length

    override fun toString() = "M1-B/$serialNo"
}
