package hm.binkley.labs

data class TimeResponse(
    val millisAdjusted: Long,
)

data class TimeCommand(
    val millisSinceEpoch: Long,
) : Command<TimeCommand, TimeResponse>
