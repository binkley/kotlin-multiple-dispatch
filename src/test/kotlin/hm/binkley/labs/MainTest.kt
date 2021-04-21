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
3 <- ResetCommand sent to Dummy
2 <- TimeCommand sent to Dummy
BUG: Unsupported: sending M1NameCommand to Dummy
BUG: Unsupported: sending M2NameCommand to Dummy
3 <- ResetCommand sent to M1-A/123
17 <- TimeCommand sent to M1-A/123
6 <- M1NameCommand sent to M1-A/123
BUG: Unsupported: sending M2NameCommand to M1-A/123
3 <- ResetCommand sent to M1-B/456
17 <- TimeCommand sent to M1-B/456
9 <- M1NameCommand sent to M1-B/456
BUG: Unsupported: sending M2NameCommand to M1-B/456
3 <- ResetCommand sent to M2/456/SG
18 <- TimeCommand sent to M2/456/SG
4 <- M1NameCommand sent to M2/456/SG
8 <- M2NameCommand sent to M2/456/SG
        """.trimIndent() + "\n"
    }
}
