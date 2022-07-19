import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BackspaceStringCompareTest {

    @ParameterizedTest
    @MethodSource("data")
    fun backspaceCompare(s: String, t: String, e: Boolean) {
        val res = BackspaceStringCompare().backspaceCompare(s, t)
        assertEquals(e, res)
    }

    @ParameterizedTest
    @MethodSource("data")
    fun backspaceCompareOpt(s: String, t: String, e: Boolean) {
        val res = BackspaceStringCompare().backspaceCompareOpt(s, t)
        assertEquals(e, res)
    }

    @Test
    fun getString() {
        val res = BackspaceStringCompare().getString("ab#asdf##")
        assertEquals("aas", res)
    }

    companion object {
        @JvmStatic
        fun data() = listOf(
            Arguments.of("ab#c", "ad#c", true),
            Arguments.of("ab##", "c#d#", true),
            Arguments.of("a#c", "t", false),
        )
    }
}