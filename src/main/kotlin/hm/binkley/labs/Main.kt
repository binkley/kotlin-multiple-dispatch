package hm.binkley.labs

import kotlin.reflect.KClass

fun main() {
    register { d: DummyDevice, c: ResetCommand ->
        d.runReset(c)
    }

    try {
        println(dispatch(DummyDevice, ResetCommand))
        println(dispatch(DummyDevice, TimeCommand(0L)))
    } catch (e: MissingMethodException) {
        println("BUG: $e")
    }
}

@Suppress("UNCHECKED_CAST")
private inline fun <reified D : Device<D>, reified C : Command<C>> register(
    noinline lambda: (D, C) -> Int,
) {
    val key: Pair<KClass<Device<*>>, KClass<Command<*>>> =
        (D::class as KClass<Device<*>>) to (C::class as KClass<Command<*>>)
    dispatchTable[key] = lambda as (Device<*>, Command<*>) -> Int
}

private val dispatchTable: MutableMap<
    Pair<KClass<Device<*>>, KClass<Command<*>>>,
    (Device<*>, Command<*>) -> Int
    > = mutableMapOf()

internal inline fun <reified D : Device<D>, reified C : Command<C>> dispatch(
    device: D,
    command: C,
): Int {
    @Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")
    val lambda = dispatchTable.get(D::class to C::class)
        ?: throw MissingMethodException(device, command)

    return lambda(device, command)
}
