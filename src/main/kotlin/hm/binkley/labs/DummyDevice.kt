package hm.binkley.labs

object DummyDevice : Device<DummyDevice> {
    @Suppress("UNUSED_PARAMETER")
    fun runReset(c: ResetCommand): Int = 3

    override fun toString() = this::class.simpleName!!
}
