package hm.binkley.labs

import kotlin.reflect.KClass

private val dispatchTable: MutableMap<
    Pair<KClass<Device<*>>, KClass<Command<*>>>,
    (Device<*>, Command<*>) -> Int
    > = mutableMapOf()

@Suppress("UNCHECKED_CAST")
internal inline fun <reified D : Device<D>, reified C : Command<C>> register(
    noinline lambda: (D, C) -> Int,
) {
    val key: Pair<KClass<Device<*>>, KClass<Command<*>>> =
        (D::class as KClass<Device<*>>) to (C::class as KClass<Command<*>>)
    dispatchTable[key] = lambda as (Device<*>, Command<*>) -> Int
}

internal fun dispatch(device: Device<*>, command: Command<*>): Int {
    val deviceType = device::class
    val commandType = command::class

    val lambda = dispatchTable[deviceType to commandType]
        ?: throw MissingMethodException(device, command)

    return lambda(device, command)
}
