package hm.binkley.labs.command

import hm.binkley.labs.Command

/** Reset is identical for all devices. */
object ResetCommand : Command<ResetCommand, Unit>

internal fun sendReset() = Unit
