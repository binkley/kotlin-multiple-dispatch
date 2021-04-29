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
kotlin.Unit <- ResetCommand sent to M1-A/1-2-3
TimeResponse(millisAdjusted=1) <- TimeCommand sent to M1-A/1-2-3
true <- M1NameCommand sent to M1-A/1-2-3
BUG: Unsupported: sending M2NameCommand to M1-A/1-2-3
kotlin.Unit <- ResetCommand sent to M1-B/4-5-6
TimeResponse(millisAdjusted=1) <- TimeCommand sent to M1-B/4-5-6
false <- M1NameCommand sent to M1-B/4-5-6
BUG: Unsupported: sending M2NameCommand to M1-B/4-5-6
kotlin.Unit <- ResetCommand sent to M2/7-8-9-0/SG
TimeResponse(millisAdjusted=1) <- TimeCommand sent to M2/7-8-9-0/SG
false <- M1NameCommand sent to M2/7-8-9-0/SG
M2NameResponse(success=true) <- M2NameCommand sent to M2/7-8-9-0/SG
        """.trimIndent() + "\n"
    }
}
