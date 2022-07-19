class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        nums.indices.forEach { i1 ->
            for (i2 in nums.indices) {
                if (i2 <= i1) continue
                if (nums[i1] + nums[i2] == target)
                    return intArrayOf(i1, i2)
            }
        }
        return intArrayOf()
    }

    fun twoSumOptimization(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.withIndex().forEach { (index, value) ->
            if (value in map)
                return intArrayOf(map[value]!!, index)

            map[target - value] = index

        }
        return intArrayOf()
    }
}