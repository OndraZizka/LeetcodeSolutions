class Leet167_TwoSumII {

    fun twoSum(numbers: IntArray, target: Int): IntArray {

        /*fun binSearchIndexOf(target: Int, range: IntRange): Int {
            if (range.start == range.last) return range.last

            val midPos = (range.last - range.first) / 2
            val midVal = numbers[midPos]
            if (midVal == target) return midPos
            if (numbers[midPos]) > target
                return binSearchIndexOf(target, range.first..midPos-1)
            else
                return binSearchIndexOf(target, (midPos+1)..range.last)
        }

        val closestPos = binSearchIndexOf(target, 0..numbers.size-1)
        */

        var lPos = 0
        var rPos = numbers.size-1
        while (true) {
            val remainder = target - numbers[lPos]

            val curR = numbers[rPos]
            if (curR == remainder)
                return intArrayOf(lPos+1, rPos+1)
            if (curR > remainder)
                rPos--
            else lPos++

            if (rPos == lPos)
                return intArrayOf(-1, -1) // ERROR
        }
    }

}
