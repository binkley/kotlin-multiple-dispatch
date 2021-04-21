package hm.binkley.labs

interface Command<C : Command<C>> {
    @Suppress("UNCHECKED_CAST")
    fun self() = this as C
}
