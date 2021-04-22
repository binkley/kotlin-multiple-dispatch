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

internal fun <D : Device<D>, C : Command<C>> dispatch(
    device: D,
    command: C,
): Int {
    val deviceType = device::class
    val commandType = command::class

    @Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")
    val lambda = dispatchTable.get(deviceType to commandType)
        ?: throw MissingMethodException(device, command)

    return lambda(device, command)
}
