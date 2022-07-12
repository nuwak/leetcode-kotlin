import java.lang.Integer.max
import java.lang.Integer.min
import kotlin.system.measureTimeMillis

/**
 * @see https://leetcode.com/problems/container-with-most-water/
 */
class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var acc = 0
        height.forEachIndexed { index1, value1 ->
            height.forEachIndexed it2@{ index2, value2 ->
                if (index1 >= index2) return@it2

                val area = (min(value1, value2) * (index2 - index1))
                if (acc < area) acc = area
            }
        }

        return acc
    }


    fun maxArea2(height: IntArray): Int {
        var acc = 0
        val time = measureTimeMillis {
            for ((index1, value1) in height.withIndex()) {
                for ((index2, value2) in height.withIndex()) {
                    val area = (min(value1, value2) * (index2 - index1))
                    if (acc < area) acc = area
                }
            }
        }
        println(time)

        return acc
    }


    fun maxArea3(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxArea = 0
        var v1: Int
        var v2: Int

        while (left < right) {
            v1 = height[left]
            v2 = height[right]
            val area = min(v1, v2) * (right - left)
            maxArea = max(area, maxArea)
            if (v1 > v2) right-- else left++
        }

        return maxArea
    }
}