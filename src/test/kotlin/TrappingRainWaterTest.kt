import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.system.measureNanoTime


internal class TrappingRainWaterTest {


    @ParameterizedTest
    @MethodSource("data")
    fun trap(input: IntArray, ex: Int) {
        val res: Int
        measureNanoTime {
            res = TrappingRainWater().trap(input)
        }.also {
            (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())
                .also { println("Used memory is kb: " + it / 1024) }
            println("normal $it")
        }

        assertEquals(ex, res)
    }

    @ParameterizedTest
    @MethodSource("data")
    fun trapOpt(input: IntArray, ex: Int) {
        val res: Int
        measureNanoTime {
            res = TrappingRainWater().trapOpt(input)
        }.also {
            (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())
                .also { println("Used memory is kb: " + it / 1024) }
            println("opt $it")
        }

        assertEquals(ex, res)
    }

    @ParameterizedTest
    @MethodSource("data")
    fun trapOpt2(input: IntArray, ex: Int) {
        val res: Int
        measureNanoTime {
            res = TrappingRainWater().trapOpt2(input)
            (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())
                .also { println("Used memory is kb: " + it / 1024) }
        }.also {
            println("opt2 $it")
        }

        assertEquals(ex, res)
    }

    @ParameterizedTest
    @MethodSource("data")
    fun trapOpt3(input: IntArray, ex: Int) {
        val res: Int
        measureNanoTime {
            res = TrappingRainWater().trapOpt3(input)
        }.also {
            (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())
                .also { println("Used memory is kb: " + it / 1024) }
            println("normal $it")
        }

        assertEquals(ex, res)
    }

    companion object {
        @JvmStatic
        fun data() = listOf(
            Arguments.of(intArrayOf(4, 2, 0, 3, 2, 5), 9),
            Arguments.of(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1), 6),
            Arguments.of(intArrayOf(0, 2, 0), 0),
            Arguments.of(intArrayOf(5, 5, 1, 7, 1, 1, 5, 2, 7, 6), 23),
            Arguments.of(intArrayOf(5, 4, 1, 2), 1),
        )
    }
}