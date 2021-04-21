package hm.binkley.labs

object DummyDevice : Device<DummyDevice> {
    fun runTime(c: TimeCommand) = (2 * c.millisSinceEpoch).toInt()

    override fun toString() = "Dummy"
}
