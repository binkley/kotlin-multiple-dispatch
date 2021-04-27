package hm.binkley.labs

import kotlin.reflect.KClass

private val dispatchTable: MutableMap<
    Pair<KClass<Device<*>>, KClass<Command<*>>>,
    (Device<*>, Command<*>) -> Int
    > = mutableMapOf()

/** @todo See if this can be simplified like [dispatch] */
@Suppress("UNCHECKED_CAST")
internal inline fun <reified D : Device<D>, reified C : Command<C>> register(
    noinline lambda: (D, C) -> Int,
) {
    val key: Pair<KClass<Device<*>>, KClass<Command<*>>> =
        (D::class as KClass<Device<*>>) to (C::class as KClass<Command<*>>)
    dispatchTable[key] = lambda as (Device<*>, Command<*>) -> Int
}

/**
 * *NB* &mdash; Using `reified` removed the need to look up class type in the
 * function body, however lowers readability.
 */
internal fun Device<*>.dispatch(command: Command<*>): Int {
    val deviceType = this::class
    val commandType = command::class

    val lambda = dispatchTable[deviceType to commandType]
        ?: throw MissingMethodException(this, command)

    return lambda(this, command)
}
