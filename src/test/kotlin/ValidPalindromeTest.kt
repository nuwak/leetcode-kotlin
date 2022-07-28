import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ValidPalindromeTest {
    @ParameterizedTest
    @MethodSource("data")
    fun backspaceCompare(s: String, e: Boolean) {
        val res = ValidPalindrome().solution(s)
        assertEquals(e, res)
    }

    companion object {
        @JvmStatic
        fun data() = listOf(
            Arguments.of("A man, a plan, a canal: Panama", true),
            Arguments.of("race a car", false),
            Arguments.of("0P", false),
        )
    }
}