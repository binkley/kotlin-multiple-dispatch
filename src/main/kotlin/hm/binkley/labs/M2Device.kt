package hm.binkley.labs

data class M2Device(
    val serialNo: Long,
    val carrierCountry: String,
) : Device<M2Device> {
    fun runTime(c: TimeCommand) = (18 * c.millisSinceEpoch).toInt()

    fun runName(c: M1NameCommand) = c.name.length + 1 // An oddball case!
    fun runName(c: M2NameCommand) = c.humanName.length + c.internalName.length

    override fun toString() = "M2/$serialNo/$carrierCountry"
}