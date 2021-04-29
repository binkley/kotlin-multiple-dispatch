package hm.binkley.labs.command

import hm.binkley.labs.Command

data class M2NameResponse(
    val success: Boolean,
)

data class M2NameCommand(
    val humanName: String,
    val internalName: String,
) : Command<M2NameCommand, M2NameResponse>
