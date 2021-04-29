package hm.binkley.labs

data class M1NameCommand(
    val name: String,
) : Command<M1NameCommand, Boolean>
