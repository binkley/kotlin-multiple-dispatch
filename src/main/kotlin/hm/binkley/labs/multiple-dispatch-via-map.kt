package hm.binkley.labs

import kotlin.reflect.KClass

private typealias DeviceType = KClass<Device<*>>
private typealias CommandType = KClass<Command<*>>

private val dispatchTable: MutableMap<
    Pair<DeviceType, CommandType>, (Device<*>, Command<*>) -> Int
    > = mutableMapOf()

@Suppress("UNCHECKED_CAST")
internal inline fun <reified D : Device<D>, reified C : Command<C>>
register(noinline lambda: (D, C) -> Int) {
    val key: Pair<DeviceType, CommandType> =
        (D::class as DeviceType) to (C::class as CommandType)
    dispatchTable[key] = lambda as (Device<*>, Command<*>) -> Int
}

/**
 * *NB* &mdash; Using `reified` removes the need to look up class type in the
 * function body, however lowers readability.
 */
internal fun Device<*>.dispatch(command: Command<*>): Int {
    val deviceType = this::class
    val commandType = command::class

    val lambda = dispatchTable[deviceType to commandType]
        ?: throw MissingMethodException(this, command)

    return lambda(this, command)
}
