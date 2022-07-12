import java.lang.Integer.min
import java.util.Collections.max

/**
 * @see https://leetcode.com/problems/trapping-rain-water/
 */
class TrappingRainWater {
    fun trap(height: IntArray): Int {
        var maxR: Int = -1
        var maxL: Int = -1
        var minH: Int = -1
        return height.foldIndexed(0) { index, acc, value ->
            if (index == height.lastIndex) return acc

            if (index == 0 || maxR == value) {
                maxR = max(height.takeLast(height.lastIndex - index))
                minH = min(maxL, maxR)
            }

            if (index == 0 || maxL < value) {
                maxL = value
                minH = min(maxL, maxR)
            }

            val res = (minH - value).let { if (it > 0) it else 0 } + acc
            res
        }
    }

    fun trapOpt(height: IntArray): Int {
        var maxR = 0
        var maxL = 0
        var minH = 0
        return height.foldIndexed(0) { index, acc, value ->
            if (index == height.lastIndex) return acc

            if (index == 0 || maxR == value) {
                var i = index + 1
                maxR = 0
                while (i < height.size) {
                    if (height[i] > maxR) {
                        maxR = height[i]
                    }
                    i++
                }
                minH = min(maxL, maxR)
            }

            if (index == 0 || maxL < value) {
                maxL = value
                minH = min(maxL, maxR)
            }

            val res = minH - value
            (if (res > 0) res else 0) + acc
        }
    }

    fun trapOpt2(height: IntArray): Int {
        var maxR = 0
        var maxL = 0
        var minH = 0
        var acc = 0
        for ((index, value) in height.withIndex()) {
            if (index == height.lastIndex) return acc

            if (index == 0 || maxR == value) {
                maxR = 0
                for (i in (index + 1)..height.lastIndex) {
                    if (height[i] > maxR)
                        maxR = height[i]
                }
                minH = min(maxL, maxR)
            }

            if (index == 0 || maxL < value) {
                maxL = value
                minH = min(maxL, maxR)
            }

            val res = minH - value
            acc += (if (res > 0) res else 0)
        }

        return acc
    }

    fun trapOpt3(height: IntArray): Int {
        var (left, totalWater, maxLeft, maxRight) = listOf(0, 0, 0, 0)
        var right = height.lastIndex

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft)
                    maxLeft = height[left]
                else
                    totalWater += maxLeft - height[left]
                left++
            } else {
                if (height[right] >= maxRight)
                    maxRight = height[right]
                else
                    totalWater += maxRight - height[right]
                right--
            }
        }

        return totalWater
    }
}