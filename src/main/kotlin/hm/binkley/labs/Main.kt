package hm.binkley.labs

import kotlin.reflect.KClass

fun main() {
    register<ResetCommand, DummyDevice>(3)

    try {
        println(dispatch(ResetCommand, DummyDevice))
        println(dispatch(TimeCommand(0L), DummyDevice))
    } catch (e: MissingMethodException) {
        println("BUG: $e")
    }
}

@Suppress("UNCHECKED_CAST")
private inline fun <reified C : Command<C>, reified D : Device<D>> register(
    result: Int,
) {
    val key: Pair<KClass<Command<*>>, KClass<Device<*>>> =
        (C::class as KClass<Command<*>>) to (D::class as KClass<Device<*>>)
    dispatchTable[key] = result
}

private val dispatchTable: MutableMap<
    Pair<KClass<Command<*>>, KClass<Device<*>>>,
    Int
    > = mutableMapOf()

internal inline fun <reified C : Command<C>, reified D : Device<D>> dispatch(
    command: C,
    device: D,
): Int {
    @Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")
    val lambda = dispatchTable.get(C::class to D::class)
        ?: throw MissingMethodException(command, device)
    return lambda
}
