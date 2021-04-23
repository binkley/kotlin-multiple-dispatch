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
3 <- ResetCommand sent to M1-A/1-2-3
17 <- TimeCommand sent to M1-A/1-2-3
6 <- M1NameCommand sent to M1-A/1-2-3
BUG: Unsupported: sending M2NameCommand to M1-A/1-2-3
3 <- ResetCommand sent to M1-B/4-5-6
17 <- TimeCommand sent to M1-B/4-5-6
9 <- M1NameCommand sent to M1-B/4-5-6
BUG: Unsupported: sending M2NameCommand to M1-B/4-5-6
3 <- ResetCommand sent to M2/7-8-9-0/SG
18 <- TimeCommand sent to M2/7-8-9-0/SG
4 <- M1NameCommand sent to M2/7-8-9-0/SG
8 <- M2NameCommand sent to M2/7-8-9-0/SG
        """.trimIndent() + "\n"
    }
}
