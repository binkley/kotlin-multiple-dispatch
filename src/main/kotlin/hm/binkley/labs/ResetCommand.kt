package hm.binkley.labs

/** Reset is identical for all devices. */
object ResetCommand : Command<ResetCommand>

/** Reset is identical for all devices. */
internal fun runReset() = 3
