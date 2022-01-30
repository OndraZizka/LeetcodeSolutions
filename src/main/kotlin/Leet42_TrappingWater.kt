import kotlin.math.min

class Leet42_TrappingWater {

    fun trap(height: IntArray): Int {

        val maxesOnLeft = mutableListOf<Pair<Int, Int>>()  // Height, position
        val maxesOnRight = mutableListOf<Pair<Int, Int>>()  // Height, position

        // Left maxes
        var curMax = 0
        height.forEachIndexed { i, h ->
            if (h > curMax) {
                curMax = h
                maxesOnLeft.add(Pair(h, i))
            }
        }

        curMax = 0
        for (i in (height.size - 1)downTo 0) {
            val h  = height[i]
            if (h > curMax) {
                curMax = h
                maxesOnRight.add(Pair(h, i))
            }
        }

        var sumWater = 0
        height.forEachIndexed { i, h ->
            val maxL = maxesOnLeft.asSequence().filter { it.second < i }.lastOrNull()?.first ?: 0
            val maxR = maxesOnRight.asSequence().filter { it.second > i }.lastOrNull()?.first ?: 0
            val waterHere = Math.min(maxL, maxR) - h
            sumWater += Math.max(0, waterHere)
        }

        return sumWater
    }
}

fun main() {
    Leet42_TrappingWater().trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1))
}
