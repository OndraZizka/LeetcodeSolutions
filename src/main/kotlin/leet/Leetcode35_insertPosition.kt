package leet

class Leetcode35_insertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var curPos = 0
        for (nu in nums) {
            if (nu < target)
                return curPos
            curPos++
        }
        return curPos
    }
}
