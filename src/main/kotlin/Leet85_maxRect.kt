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
             matFolded.map { it[i] }.also { println("Transposed: $it") }
        }
        val maxRectArea = transposed
            .mapIndexed{ i, it -> maxRectInHistogram(it).also { println("Row $i max rectangle: $it") } }
            .sortedDescending().first() //transposed.maxOf { maxRectInHistogram(it) }

        return maxRectArea
    }

    data class AreaStartAndHeight(val startIndex: Int, val height: Int)

    private fun maxRectInHistogram(histogram: List<Int>): Int {

        val stack = Stack<AreaStartAndHeight>()
        fun lastHeightAtStack() = if (stack.empty()) 0 else stack.peek().height
        var maxArea = 0
        val maxIndex = histogram.size - 1

        for (i in 0..maxIndex) {
            val curHeight = histogram[i]
            if (curHeight > lastHeightAtStack()) {
                stack.push(AreaStartAndHeight(i, curHeight))
            }
            else if (curHeight < lastHeightAtStack())
            {
                var width = 0
                while (!stack.empty() ) {
                    val areaX = stack.peek()
                    width = i - areaX.startIndex
                    val areaHeight = histogram[areaX.startIndex]
                    if (areaX.height > curHeight) {
                        maxArea = Math.max(maxArea, areaX.height * width)
                        stack.pop()
                    }
                    else break // No more popping
                }
                if (curHeight != 0)
                    stack.push(AreaStartAndHeight(i - width, curHeight))
            }
        }
        while (!stack.empty()) {
            val pop = stack.pop()
            val startAt = pop.startIndex
            val area = (maxIndex - startAt +1) * pop.height
            maxArea = Math.max(maxArea, area)
        }
        return maxArea
    }
}

fun main() {
    var matrix = arrayOf(
        "10100".toCharArray(),
        "10111".toCharArray(),
        "11111".toCharArray(),
        "10010".toCharArray(),
    )
    //matrix = arrayOf("1".toCharArray())

    val res = Leet85_maxRect().maximalRectangle(matrix)
    println("Res: $res")
}
