import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ContainerWithMostWaterTest {

    @ParameterizedTest
    @MethodSource("data")
    fun maxArea(input: IntArray, expectation: Int) {
        val res = ContainerWithMostWater().maxArea(input)
        assertEquals(expectation, res)
    }

    @ParameterizedTest
    @MethodSource("data")
    fun maxArea2(input: IntArray, expectation: Int) {
        val res = ContainerWithMostWater().maxArea3(input)
        assertEquals(expectation, res)
    }

    companion object {
        @JvmStatic
        fun data() = listOf(
            Arguments.of(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7), 49),
            Arguments.of(intArrayOf(4, 3, 2, 1, 4), 16),
            Arguments.of(intArrayOf(2, 3, 4, 5, 18, 17, 6), 17),
        )
    }
}