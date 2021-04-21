package hm.binkley.labs

interface Device<D : Device<D>> {
    @Suppress("UNCHECKED_CAST")
    fun self() = this as D
}
