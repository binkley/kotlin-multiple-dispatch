package hm.binkley.labs

internal fun registerAll() {
    // Reset command is common to all
    register { _: M1ADevice, _: ResetCommand -> sendReset() }
    register { _: M1BDevice, _: ResetCommand -> sendReset() }
    register { _: M2Device, _: ResetCommand -> sendReset() }
    // Time command varies by device
    register { d: M1ADevice, c: TimeCommand -> d.sendTimeToM1(c) }
    register { d: M1BDevice, c: TimeCommand -> d.sendTimeToM1(c) }
    register { d: M2Device, c: TimeCommand -> d.sendTimeToM2(c) }
    // Name command has different versions
    // No v2 name command defined for the M1 devices
    register { d: M1ADevice, c: M1NameCommand -> d.sendName1ToM1A(c) }
    register { d: M1BDevice, c: M1NameCommand -> d.sendName1ToM1B(c) }
    register { d: M2Device, c: M1NameCommand -> d.sendName1ToM2(c) }
    register { d: M2Device, c: M2NameCommand -> d.sendName2ToM2(c) }
}
