package hm.binkley.labs

/** Reset is identical for all devices. */
object ResetCommand : Command<ResetCommand, Unit>

internal fun runReset() = Unit
