package twoSum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun towSumTest() {
        val res = Solution().twoSum(intArrayOf(1, 2, 3, 4, 5, 6), 11)
        assertArrayEquals(res, intArrayOf(4, 5))
    }

    @Test
    fun twoSumOptimizationTest() {
        val res = Solution().twoSumOptimization(intArrayOf(1, 2, 3, 4, 5, 6), 11)
        assertArrayEquals(res, intArrayOf(4, 5))
    }
}