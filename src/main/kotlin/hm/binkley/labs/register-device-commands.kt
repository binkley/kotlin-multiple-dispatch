package hm.binkley.labs

internal fun registerAll() {
    // Reset command is common to all
    register { d: DummyDevice, _: ResetCommand -> d.runReset() }
    register { d: M1ADevice, _: ResetCommand -> d.runReset() }
    register { d: M1BDevice, _: ResetCommand -> d.runReset() }
    register { d: M2Device, _: ResetCommand -> d.runReset() }
    // Time command varies by device
    register { d: DummyDevice, c: TimeCommand -> d.runTime(c) }
    register { d: M1ADevice, c: TimeCommand -> d.runTime(c) }
    register { d: M1BDevice, c: TimeCommand -> d.runTime(c) }
    register { d: M2Device, c: TimeCommand -> d.runTime(c) }
    // Name command has different versions
    // No name command v1 defined for the dummy device
    // No name command v2 defined for the M1 devices
    register { d: M1ADevice, c: M1NameCommand -> d.runName(c) }
    register { d: M1BDevice, c: M1NameCommand -> d.runName(c) }
    register { d: M2Device, c: M1NameCommand -> d.runName(c) }
    register { d: M2Device, c: M2NameCommand -> d.runName(c) }
}
