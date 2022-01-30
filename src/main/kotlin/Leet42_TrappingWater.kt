class Leet42_TrappingWater {

    fun trap(height: IntArray): Int {

        var posL = 0
        var posR = height.size - 1
        var maxL = height[posL]
        var maxR = height[posR]
        var sumWater = 0

        while (posL != posR) {

            val localPos: Int
            val localHighestSpillingDam =
                if (maxL < maxR) {
                    val localDam = Math.min(maxL, maxR)
                    localPos = ++posL
                    maxL = Math.max(maxL, height[posL])
                    localDam
                } else {
                    val localDam = Math.min(maxL, maxR)
                    localPos = --posR
                    maxR = Math.max(maxR, height[posR])
                    localDam
                }

            val waterHere = localHighestSpillingDam - height[localPos]
            if (waterHere > 0) {
                sumWater += waterHere
            }
            println ("[$localPos] h: ${height[localPos]}, localDam: $localHighestSpillingDam; Adding $waterHere")
        }
        return sumWater
    }
}

fun main() {
    val trap = Leet42_TrappingWater().trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) // 6
    println("Trapped: $trap")
}
