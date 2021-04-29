package hm.binkley.labs

class M1BDevice(
    private val serialNo: String,
) : M1Device<M1BDevice> {
    fun runName(c: M1NameCommand) = c.name.isEmpty()

    override fun toString() = "M1-B/$serialNo"
}
