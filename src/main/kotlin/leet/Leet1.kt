package leet

class Leet1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val counts = nums.asList().groupingBy { it }.eachCount()

        for (cur in nums) {
            val counterPart = target - cur
            val hit = counts[counterPart]
            if (hit == null) continue
            if (cur == counterPart) {
                if (hit == 1) continue
            }
            val asList = nums.toList()
            val counterpartIndex = asList.lastIndexOf(counterPart)
            return intArrayOf(asList.indexOf(cur), counterpartIndex)
        }
        return intArrayOf(-1, -1)
    }
}

