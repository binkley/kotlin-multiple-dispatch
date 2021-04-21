package hm.binkley.labs

class MissingMethodException(
    device: Device<*>,
    command: Command<*>,
) : UnsupportedOperationException(
    "Unsupported: ${command::class.simpleName} to $device"
)
