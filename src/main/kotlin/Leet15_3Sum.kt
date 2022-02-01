class Leet15_3Sum {

    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        nums.sort()
        println("Sorted: ${nums.joinToString()}")

        val res = mutableListOf<List<Int>>()

        var posL = 0
        var posR = nums.size - 1
        var lastShiftedWasRight = true

        var prevL = Integer.MIN_VALUE
        var prevR = Integer.MAX_VALUE
        while (posL != posR) {
            val numL = nums[posL]
            val numR = nums[posR]
            println("L: [$posL] = $numL | R: [$posR] = $numR ")

            do {
                // Check if we have enough same numbers if they are needed.
                val complement = -(numL + numR)
                if (complement <= numL && nums[posL+1] != complement)
                    continue
                if (complement >= numR && nums[posR-1] != complement)
                    continue

                // Skip the repeated.
                if (numL == prevL) { posL++; continue }
                if (numR == prevR) { posR--; continue }

                // if (complement is not between posL and posR) continue
                for (i in posL+1..posR-1) {
                    if (nums[i] > complement) continue
                    if (nums[i] == complement) {
                        res.add(listOf(numL, complement, numR))
                        break
                    }
                }

            } while (false)

            // Which one to shift
            if (numL < 0 && lastShiftedWasRight && nums[posL+1] != 0) {
                if (numR <= 0) break
                posL++
                lastShiftedWasRight = false
                prevL = numL
            } else if (numR > 0) {
                if (numL >= 0) break
                posR--
                lastShiftedWasRight = true
                prevR = numR
            }
            else break


        }
        return res
    }
}

fun main() {
    var nums = intArrayOf(-1, 0, 1, 2, -1, -4)
    nums = intArrayOf(-2,0,1,1,2)
    nums = intArrayOf(3,0,-2,-1,1,2)
    val res = Leet15_3Sum().threeSum(nums)
    println("$res")
}
