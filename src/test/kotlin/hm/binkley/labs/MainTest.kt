package hm.binkley.labs

import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MainTest {
    @Test
    fun `should run`() {
        val out = tapSystemOut() {
            main()
        }

        out shouldBe """
            3
            BUG: hm.binkley.labs.MissingMethodException: Missing method for TimeCommand(millisSinceEpoch=0) to DummyDevice
        """.trimIndent() + "\n"
    }
}
