package leet

class Leetcode435_nonoverlappingIntervals {

    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {

        intervals.sortBy { it[0] }
        var toRemove = 0

        var prev = intervals[0]
        for (interval in intervals.drop(1)) {

            if (prev[1] > interval[0]) {
                toRemove++
                if (prev[1] > interval[1]) {
                    prev = interval
                }
            }
            else
                prev = interval
        }
        return toRemove
    }
}
