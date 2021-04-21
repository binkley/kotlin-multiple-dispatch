package hm.binkley.labs

class MissingMethodException(
    device: Device<*>,
    command: Command<*>,
) : UnsupportedOperationException(
    "Unsupported: sending ${command::class.simpleName} to $device"
)
