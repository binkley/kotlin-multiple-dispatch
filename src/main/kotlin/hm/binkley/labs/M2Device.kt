package hm.binkley.labs

class M2Device(
    private val serialNo: String,
    private val carrierCountry: String,
) : Device<M2Device> {
    fun sendTimeToM2(c: TimeCommand) = TimeResponse(c.millisSinceEpoch % 7)

    fun sendName1ToM2(c: M1NameCommand) = 0 == c.name.length % 2

    fun sendName2ToM2(c: M2NameCommand) = M2NameResponse(
        0 == (c.humanName.length + c.internalName.length) % 2
    )

    override fun toString() = "M2/$serialNo/$carrierCountry"
}
