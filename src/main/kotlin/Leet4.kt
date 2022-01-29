import kotlin.random.Random
import kotlin.random.nextUInt

class Leet4 {

    class MyPair(var first: Int, var second: Int) {
        override fun toString(): String = "($first, $second)"
    }

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

        val lastIndex = nums1.size + nums2.size - 1
        val medianPos = Pair(lastIndex / 2, (lastIndex / 2) + (lastIndex % 2))

        println("LastIndex: $lastIndex; Median positions: $medianPos")

        val medVal = MyPair(0,0)
        var posA = 0
        var posB = 0

        while (true) {
            if (posA + posB == lastIndex)  break

            // Take the lesser on each cycle.
            val curA = nums1[posA]
            val curB = nums2[posB]
            val take: Int

            println("MedPos $medianPos, posA $posA => $curA, posB $posB => $curB; MedVal $medVal")

            if (curA <= curB) {
                take = curA;
                if (posA < nums1.size-1)
                    posA++
            }
            else {
                take = curB;
                if (posB < nums2.size-1)
                    posB++
            }

            if (posA + posB == medianPos.first) {
                medVal.first = take
            }
            else if (posA + posB == medianPos.second) {
                medVal.second = take
                println("MedVal at the end: $medVal")
                break
            }

        }

        val median = 0.5 * (medVal.first + medVal.second)

        return median
    }


}

fun main() {
    val med = Leet4().findMedianSortedArrays(intArrayOf(10,20,30), intArrayOf(20,30,40))
    println("Median: $med")
    val med2 = Leet4().findMedianSortedArrays(generateInts(50), generateInts(60))
    println("Median: $med2")
}

fun generateInts(len: Int): IntArray = IntArray(len) { Random.nextUInt(1000u).toInt() }.sortedArray()

class MyPair(var first: Int, var second: Int) {
    override fun toString(): String = "($first, $second)"
}
