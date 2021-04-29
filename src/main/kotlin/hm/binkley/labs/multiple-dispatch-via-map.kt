package hm.binkley.labs

import kotlin.reflect.KClass

private typealias SomeDevice = Device<*>
private typealias SomeCommand = Command<*, *>
private typealias SendCommand = (SomeDevice, SomeCommand) -> Any
private typealias DeviceType = KClass<SomeDevice>
private typealias CommandType = KClass<SomeCommand>

private val dispatchTable: MutableMap<
    Pair<DeviceType, CommandType>, SendCommand> = mutableMapOf()

@Suppress("UNCHECKED_CAST")
internal inline fun <reified D : Device<D>, reified C : Command<C, R>, R>
register(noinline lambda: (D, C) -> R) {
    val key: Pair<DeviceType, CommandType> =
        (D::class as DeviceType) to (C::class as CommandType)
    dispatchTable[key] = lambda as SendCommand
}

/**
 * *NB* &mdash; Using `reified` removes the need to look up class type in the
 * function body, however lowers readability.
 */
internal fun <R> SomeDevice.send(command: SomeCommand): R {
    val deviceType = this::class
    val commandType = command::class

    val send = dispatchTable[deviceType to commandType]
        ?: throw MissingMethodException(this, command)

    @Suppress("UNCHECKED_CAST")
    return send(this, command) as R
}
