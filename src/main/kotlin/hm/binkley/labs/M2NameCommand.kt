package hm.binkley.labs

data class M2NameCommand(
    val humanName: String,
    val internalName: String,
) : Command<M2NameCommand>
