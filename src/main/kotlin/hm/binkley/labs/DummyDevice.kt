package hm.binkley.labs

object DummyDevice : Device<DummyDevice> {
    override fun toString() = this::class.simpleName!!
}
