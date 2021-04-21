package hm.binkley.labs

fun main() {
    register { d: DummyDevice, c: ResetCommand ->
        d.runReset(c)
    }

    try {
        println(dispatch(DummyDevice, ResetCommand))
        println(dispatch(DummyDevice, TimeCommand(0L)))
    } catch (e: MissingMethodException) {
        println("BUG: $e")
    }
}
