import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ValidParenthesesTest {
    @ParameterizedTest
    @MethodSource("data")
    fun backspaceCompare(s: String, e: Boolean) {
        val res = ValidParentheses().solution(s)
        assertEquals(e, res)
    }

    companion object {
        @JvmStatic
        fun data() = listOf(
            Arguments.of("()", true),
            Arguments.of("()[]{}", true),
            Arguments.of("(]", false),
            Arguments.of("{[]}", true),
        )
    }
}