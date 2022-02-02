package leet

class Leet53_maxSubarray_KadaneAlg {

    fun maxSubArray(nums: IntArray): Int {

        var curLargerSum = 0
        var maxSum = java.lang.Integer.MIN_VALUE

        for (i in nums) {
            curLargerSum += i
            if (i > curLargerSum)
                curLargerSum = i
            if (curLargerSum > maxSum)
                maxSum = curLargerSum
        }
        return maxSum
    }

}
