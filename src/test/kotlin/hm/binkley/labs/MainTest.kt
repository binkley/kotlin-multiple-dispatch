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
2
BUG: Unsupported: M1NameCommand to Dummy
BUG: Unsupported: M2NameCommand to Dummy
3
17
6
BUG: Unsupported: M2NameCommand to M1-A/123
3
17
9
BUG: Unsupported: M2NameCommand to M1-B/456
3
18
4
8
        """.trimIndent() + "\n"
    }
}
