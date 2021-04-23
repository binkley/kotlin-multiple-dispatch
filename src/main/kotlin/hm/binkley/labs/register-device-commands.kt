package hm.binkley.labs

internal fun registerAll() {
    // Reset command is common to all
    register { _: M1ADevice, _: ResetCommand -> runReset() }
    register { _: M1BDevice, _: ResetCommand -> runReset() }
    register { _: M2Device, _: ResetCommand -> runReset() }
    // Time command varies by device
    register { d: M1ADevice, c: TimeCommand -> d.runTime(c) }
    register { d: M1BDevice, c: TimeCommand -> d.runTime(c) }
    register { d: M2Device, c: TimeCommand -> d.runTime(c) }
    // Name command has different versions
    // No v2 name command defined for the M1 devices
    register { d: M1ADevice, c: M1NameCommand -> d.runName(c) }
    register { d: M1BDevice, c: M1NameCommand -> d.runName(c) }
    register { d: M2Device, c: M1NameCommand -> d.runName(c) }
    register { d: M2Device, c: M2NameCommand -> d.runName(c) }
}
