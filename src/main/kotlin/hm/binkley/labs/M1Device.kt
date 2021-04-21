package hm.binkley.labs

interface M1Device<D : M1Device<D>> : Device<D> {
    fun runTime(c: TimeCommand) = (17 * c.millisSinceEpoch).toInt()
}
