package hm.binkley.labs

data class TimeCommand(
    val millisSinceEpoch: Long,
) : Command<TimeCommand>
