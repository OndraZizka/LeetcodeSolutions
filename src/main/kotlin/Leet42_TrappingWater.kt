class Leet42_TrappingWater {

    fun trap(height: IntArray): Int {

        val maxOnLeft  = IntArray(height.size)
        val maxOnRight = IntArray(height.size)

        // Left maxes
        var curMax = 0
        height.forEachIndexed { i, h ->
            maxOnLeft[i] = curMax
            if (h > curMax) {
                curMax = h
            }
        }

        curMax = 0
        for (i in (height.size - 1)downTo 0) {
            val h  = height[i]
            maxOnRight[i] = curMax
            if (h > curMax) {
                curMax = h
            }
        }

        var sumWater = 0
        height.forEachIndexed { i, h ->
            val maxL = maxOnLeft[i]
            val maxR = maxOnRight[i]
            val waterHere = (if (maxL < maxR) maxL else maxR) - h
            if (waterHere > 0)
                sumWater += waterHere
        }

        return sumWater
    }
}

fun main() {
    val trap = Leet42_TrappingWater().trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))
    println("Trapped: $trap")
}
