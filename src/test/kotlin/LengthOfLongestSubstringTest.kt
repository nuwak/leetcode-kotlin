import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LengthOfLongestSubstringTest {

    @ParameterizedTest
    @MethodSource("data")
    fun solution(s: String, e: Int) {
        val res = LengthOfLongestSubstring().solution(s)
        assertEquals(e, res)
    }
    @ParameterizedTest
    @MethodSource("data")
    fun solution3(s: String, e: Int) {
        val res = LengthOfLongestSubstring().solution3(s)
        assertEquals(e, res)
    }

    @ParameterizedTest
    @MethodSource("data")
    fun solution4(s: String, e: Int) {
        val res = LengthOfLongestSubstring().solution4(s)
        assertEquals(e, res)
    }

    companion object {
        @JvmStatic
        fun data() = listOf(
            Arguments.of("abcabcbb", 3),
            Arguments.of("bbbbbbbbbbb", 1),
            Arguments.of("pwwkew", 3),
            Arguments.of("aab", 2),
            Arguments.of("dvdf", 3),
        )
    }
}