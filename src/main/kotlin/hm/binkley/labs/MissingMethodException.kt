package hm.binkley.labs

class MissingMethodException(
    device: Device<*>,
    command: Command<*>,
) : Exception("Missing method for $command to $device")
