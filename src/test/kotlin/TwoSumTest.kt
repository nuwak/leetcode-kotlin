import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

internal class TwoSumTest {

    @Test
    fun towSum() {
        val res = TwoSum().twoSum(intArrayOf(1, 2, 3, 4, 5, 6), 11)
        assertArrayEquals(res, intArrayOf(4, 5))
    }

    @Test
    fun twoSumOptimization() {
        val res = TwoSum().twoSumOptimization(intArrayOf(1, 2, 3, 4, 5, 6), 11)
        assertArrayEquals(res, intArrayOf(4, 5))
    }
}