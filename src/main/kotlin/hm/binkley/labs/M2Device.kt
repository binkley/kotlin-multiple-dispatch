package hm.binkley.labs

class M2Device(
    private val serialNo: String,
    private val carrierCountry: String,
) : Device<M2Device> {
    @Suppress("UNUSED_PARAMETER")
    fun runTime(c: TimeCommand) = TimeResponse(7L)

    @Suppress("UNUSED_PARAMETER")
    fun runName(c: M1NameCommand) = true

    @Suppress("UNUSED_PARAMETER")
    fun runName(c: M2NameCommand) = M2NameResponse(true)

    override fun toString() = "M2/$serialNo/$carrierCountry"
}
