package hm.binkley.labs.command

import hm.binkley.labs.Command

data class TimeResponse(
    val millisAdjusted: Long,
)

data class TimeCommand(
    val millisSinceEpoch: Long,
) : Command<TimeCommand, TimeResponse>
