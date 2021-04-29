package hm.binkley.labs.device

import hm.binkley.labs.Device
import hm.binkley.labs.command.TimeCommand
import hm.binkley.labs.command.TimeResponse

interface M1Device<D : M1Device<D>> : Device<D> {
    fun sendTimeToM1(c: TimeCommand) = TimeResponse(c.millisSinceEpoch % 3)
}
