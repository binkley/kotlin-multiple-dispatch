package hm.binkley.labs

class MissingMethodException(
    command: Command<*>,
    device: Device<*>,
) : Exception("Missing method for $command to $device")
