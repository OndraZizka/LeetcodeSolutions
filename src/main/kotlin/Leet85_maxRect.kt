import java.lang.Integer.max
import java.util.*
import kotlin.collections.ArrayList

class Leet85_maxRect {

    fun maximalRectangle(matrix: Array<CharArray>): Int {
        val matFolded = ArrayList<List<Int>>(matrix.size)
        for (row in matrix) {
            //val rowFolded = row.map { it - '0' }.runningFold(0) { a, b -> if (b == 0) 0 else (a + b) }
            var runVal = 0
            val rowFolded = row.map { it - '0' }.map { if (it == 1) runVal++; else runVal = 0; runVal }
            println(rowFolded)
            matFolded.add(rowFolded)
        }
        println()
        val transposed: List<List<Int>> = matFolded.first().mapIndexed { i, _ ->
             matFolded.map { it[i] }.also { println(it) }
        }
        val maxRectArea = transposed
            .mapIndexed{ i, it -> maxRectInHistogram(it).also { println("Row $i: $it") } }
            .sortedDescending().first() //transposed.maxOf { maxRectInHistogram(it) }

        return maxRectArea
    }

    private fun maxRectInHistogram(histogram: List<Int>): Int {

        val stack = Stack<Int>()
        var lastAtStack = 0
        var maxArea = 0

        val maxIndex = histogram.size - 1

        for (i in 0..maxIndex) {
            val curHeight = histogram[i]
            if (curHeight > lastAtStack) {
                stack.push(i)
                lastAtStack = curHeight
            }
            else {
                var width = 0
                while (!stack.empty() ) {
                    width++
                    val formerHeight = stack.peek()
                    if (formerHeight < curHeight) {
                        val area = formerHeight * width
                        maxArea = Math.max(maxArea, area)
                        stack.pop()
                        lastAtStack = if (stack.empty()) 0 else stack.peek()
                    }
                    else break
                }
                stack.push(i - width)
            }
        }
        while (!stack.empty()) {
            val startAt = stack.pop()
            val area = (maxIndex - startAt + 1) * histogram[startAt]
            maxArea = Math.max(maxArea, area)
        }
        return maxArea
    }
}

fun main() {
    val res = Leet85_maxRect().maximalRectangle(
        arrayOf(
            "10100".toCharArray(),
            "10111".toCharArray(),
            "11111".toCharArray(),
            "10010".toCharArray(),
        )
    )
    println("Res: $res")
}
