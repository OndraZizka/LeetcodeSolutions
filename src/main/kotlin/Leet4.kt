import kotlin.random.Random
import kotlin.random.nextUInt

fun xprintln(s: String) { if(true) println(s) }

class Leet4 {

    class MyPair(var first: Int, var second: Int) {
        override fun toString(): String = "($first, $second)"
    }

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

        val lastIndex = nums1.size + nums2.size - 1
        val medianPos = Pair(lastIndex / 2, (lastIndex / 2) + (lastIndex % 2))

        xprintln("LastIndex: $lastIndex; Median positions: $medianPos")

        val medVal = MyPair(0,0)
        var posA = 0
        var posB = 0

        while (true) {
            if (posA + posB == lastIndex)  break

            // Take the lesser on each cycle.
            val take: Int

            xprintln("MedPos $medianPos, posA $posA of ${nums1.size}, posB $posB of ${nums2.size}; MedVal $medVal")

            val afterLastA = posA == nums1.size

            if (!afterLastA && nums1[posA] <= nums2[posB]) {
                take = nums1[posA];
                xprintln("Taking $take from A at $posA")
                posA++
            }
            else {
                take = nums2[posB];
                xprintln("Taking $take from B at $posB")
                posB++
            }

            if (posA + posB - 1 == medianPos.first) {
                if (medianPos.first == medianPos.second)
                    return take.toDouble() // A shortcut
                else
                    medVal.first = take
            }
            else if (posA + posB - 1 == medianPos.second) {
                medVal.second = take
                xprintln("MedVal at the end: $medVal")
                break
            }

        }

        val median = 0.5 * (medVal.first + medVal.second)

        return median
    }


}

fun main() {
    for (i in listOf(
        //20 to Pair(intArrayOf(10,20,30), intArrayOf(20,30,40)),
        //2 to Pair(intArrayOf(1,3), intArrayOf(2)),
        2.5 to Pair(intArrayOf(1,2), intArrayOf(3,4)),
        //null to generateInts(50), generateInts(60)
    )) {
        val med = Leet4().findMedianSortedArrays(i.second.first, i.second.second)
        xprintln("Median: $med, expected: ${i.first}")
    }
}

fun generateInts(len: Int): IntArray = IntArray(len) { Random.nextUInt(1000u).toInt() }.sortedArray()

class MyPair(var first: Int, var second: Int) {
    override fun toString(): String = "($first, $second)"
}
