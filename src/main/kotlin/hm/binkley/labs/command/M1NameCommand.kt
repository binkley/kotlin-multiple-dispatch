package hm.binkley.labs.command

import hm.binkley.labs.Command

data class M1NameCommand(
    val name: String,
) : Command<M1NameCommand, Boolean>
