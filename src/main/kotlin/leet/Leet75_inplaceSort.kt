package leet

class Leet75_inplaceSort {

    fun sortColors(nums: IntArray): Unit {
        var pos = 0
        while (pos < nums.size) {
            if (pos == 0 || nums[pos] >= nums[pos - 1])
                pos++
            else {
                val tmp = nums[pos-1]
                nums[pos-1] = nums[pos]
                nums[pos] = tmp
                pos--
            }
        }
    }
}
