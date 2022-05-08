package leet

class Leetcode56_MergeIntervals {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {

        intervals.sortBy { it[0] }

        var previous: IntArray = intervals[0]

        val result = mutableListOf<IntArray>()

        for (current in intervals) {
            if (previous[1] >= current[0])
                previous = intArrayOf(previous[0], maxOf(current[1], previous[1]))
            else {
                result.add(previous)
                previous = current
            }
        }
        result.add(previous)

        return result.toTypedArray()
    }

}
