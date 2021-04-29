package hm.binkley.labs

interface M1Device<D : M1Device<D>> : Device<D> {
    fun runTime(c: TimeCommand) = TimeResponse(c.millisSinceEpoch % 3)
}
