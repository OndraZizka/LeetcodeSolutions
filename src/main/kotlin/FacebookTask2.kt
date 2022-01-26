/*
Above-Average Subarrays

You are given an array A containing N integers. Your task is to find all subarrays whose average sum is greater than the average sum of the remaining array elements.
You must return the start and end index of each subarray in sorted order.
A subarray that starts at position L1 and ends at position R1 comes before a subarray that starts at L2 and ends at R2 if L1 < L2, or if L1 = L2 and R1 ≤ R2.
Note that we'll define the average sum of an empty array to be 0, and we'll define the indicies of the array (for the purpose of output) to be 1 through N. A subarray that contains a single element will have L1 = R1.
Signature
Subarray[] aboveAverageSubarrays(int[] A)

Input
1 ≤ N ≤ 2,000
1 ≤ A[i] ≤ 1,000,000

Output
A Subarray is an object with two integer fields, left and right, defining the range that a given subarray covers. Return a list of all above-average subarrays sorted as explained above.

Example 1
A = [3, 4, 2]
output = [[1, 2], [1, 3], [2, 2]]

The above-average subarrays are [3, 4], [3, 4, 2], and [4].

1  1000 1  1000
 */
fun main() {

}

class Window (var sum: Int = 0, var len: Int = 0, var start: Int = 0) {
    fun advance(value: Int) {
        this.sum += value
        this.len++
    }
    fun retract(input: List<Int>) {
        this.sum += input[this.start]
        this.start++
        this.len--
    }
    fun retract(value: Int) {
        this.sum += value
        this.start++
        this.len--
    }
    fun getAverage() = this.sum.toDouble() / this.len.toDouble()
    fun plus(other: Window) = Window(this.sum + other.sum, this.len + other.len)
    fun end() = this.start + this.len
}


fun aboveAverageSubarrays(input: List<Int>): List<Subarray> {
    val results = mutableListOf<Subarray>()
    val incSums = input.runningFold(0, { cur, next -> cur + next})

    var trailing = Window(0, 0)
    var running = Window(0, 0)
    var leading = Window(input.sum(), input.size)
    var total = Window(input.sum(), input.size)

    fun advanceHead(i: Int) {
        running.advance(i)
        leading.retract(i)
    }
    fun retractTail() {
        trailing.retract(input)
        running.retract(input)
    }

    for (i in input) {
        advanceHead(i)
        retractTail()
        var curLen = 0
        val substract = incSums[running.start]
        for (end in running.end() until input.size) {
            curLen ++
            var curSum = incSums[end] - substract
            var restSum = total.sum - curSum
            if (curSum.toDouble() / curLen.toDouble() > restSum.toDouble() / input.size.toDouble() )
                results.add(Subarray(running.start, end).add1())
        }
    }
    return results
}

data class Subarray ( val left: Int, val right: Int) : Comparable<Subarray> {
    override fun compareTo(other: Subarray): Int {
        val lefts = other.left - this.left
        if (lefts != 0) return lefts
        return other.right - this.right
    }

    fun add1(): Subarray = this.copy(left + 1, right + 1)
    companion object {
        fun from(window: Window) = Subarray(window.start, window.start + window.len)
    }
}
