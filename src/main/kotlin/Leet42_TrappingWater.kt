class Leet42_TrappingWater {

    fun trap(height: IntArray): Int {

        val maxesOnLeft = mutableListOf<Pair<Int, Int>>()  // Height, position
        val maxesOnRight = mutableListOf<Pair<Int, Int>>()  // Height, position

        var curMax = 0
        height.forEachIndexed { i, h ->
            if (h > curMax) {
                curMax = h
                maxesOnRight.add(Pair(h, i))
            }
        }

        curMax = 0
        for (i in (height.size - 1)..0) { ->
            val h  = height[i]
            if (h > curMax) {
                curMax = h
                maxesOnLeft.add(Pair(h, i))
            }
        }

        height.forEachIndexed { i, h ->
            val maxL = maxesOnLeft.asSequence().filter { it.second >  }
        }

        return TODO()
    }


}
