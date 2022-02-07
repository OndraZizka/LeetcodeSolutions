package leet

import parsePairs
import java.util.*


class Leetcode1584_prims_minGraphConnectCost {
    data class CostAndPlace (val dist: Int, val placeId: Int) : Comparable<CostAndPlace> {
        override fun compareTo(other: CostAndPlace) = this.dist - other.dist
    }

    fun minCostConnectPoints(points: Array<IntArray>): Int {

        fun computeMhtDist(pA: IntArray, pB: IntArray) = Math.abs(pA[0] - pB[0]) + Math.abs(pA[1] - pB[1])
        val visited = mutableSetOf<Int>()
        val heap = PriorityQueue<CostAndPlace>()

        var pathCost = 0
        var curIndex = 0

        while (visited.size < points.size) {
            var curPoint = points[curIndex]
            visited.add(curIndex)
            // Add all connections to the heap.
            points.forEachIndexed { i, point ->
                if (!visited.contains(i)) {
                    val dist = computeMhtDist(curPoint, point)
                    println("   Adding dist = $dist from ${curPoint.joinToString()} -> ${point.joinToString()}")
                    heap.add(CostAndPlace(dist, i))
                }
            }
            // Pick up the shortest.
            var costAndPoint: CostAndPlace?
            do {
                costAndPoint = heap.poll()
                if (costAndPoint == null)
                    return pathCost
            } while (visited.contains(costAndPoint!!.placeId))


            println("   Choosing dist = ${costAndPoint.dist} from [$curIndex] to [${costAndPoint.placeId}]")
            pathCost += costAndPoint.dist
            curIndex = costAndPoint.placeId
        }

        return pathCost
    }
}

fun main() {
    val points = parsePairs("[0,0],[2,2],[3,10],[5,2],[7,0]")
    //println("${points.joinToString("; ") { it.joinToString(",") } }")

    val cost = Leetcode1584_prims_minGraphConnectCost().minCostConnectPoints(points)
    println("$cost")
}
