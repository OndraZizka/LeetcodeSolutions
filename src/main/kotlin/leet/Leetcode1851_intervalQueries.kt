package leet

import kotlin.collections.ArrayDeque

class Leetcode1851_intervalQueries {

    fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {

        intervals.sortBy { it[1] }

        // Precompute
        val lowestStartsBeyond = intervals.asList().asReversed().map { it[0] }.runningFold(0) { cur, new -> maxOf(cur, new) }.asReversed()
        val intervalsWithLowestStartBeyondThem: List<Pair<IntArray, Int>> = intervals.zip(lowestStartsBeyond)

        val queriesSorted = queries.sorted()
        val smallestIntervalByQuery = hashMapOf<Int, Int>()

        val activeQueries = ArrayDeque<Int>()

        val intervalIter = intervalsWithLowestStartBeyondThem.iterator()

        for (q in queriesSorted) {

            var interval: IntArray
            do {
                if (!intervalIter.hasNext()) break
                val (interval: IntArray, nextLarger: Int) = intervalIter.next()
                if (interval[1] >= q) {
                    // We have reached the q by the end of this interval.
                    activeQueries.add(q)

                    // Does the interval cover q?
                    if (interval[0] <= q) {
                        val iSize = interval[1] - interval[0] + 1
                        smallestIntervalByQuery.compute(q) { _, prevMinSize -> minOf(prevMinSize?: Int.MAX_VALUE, iSize) }
                    }
                    // If there is no further covering interval, kick q out of active queries.
                    //if (intervalsWithLowestStartBeyondThem[])
                    // TODO
                }

                if (interval[1] > q) break
            }
            while (true)
        }

        return intArrayOf(0)
    }

}
