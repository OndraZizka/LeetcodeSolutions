package leet

class Leetcode221_maximalSquare {

    fun maximalSquare(matrix: Array<CharArray>): Int {

        if (matrix.isEmpty() || matrix[0].isEmpty())
            return 0

        val wid = matrix[0].size

        // Dynamic programming
        val cache = Array(matrix.size+1) { IntArray(wid+1) }

        printMatrix(cache)

        var globalMax = 0

        for (y in matrix.size-1 downTo 0 ) {
            for (x in wid-1 downTo 0) {
                if (matrix[y][x] == '0')
                    continue
                val localMax = 1 + minOf(cache[y][x + 1], cache[y + 1][x], cache[y + 1][x + 1])
                cache[y][x] = localMax
                globalMax = maxOf(localMax, globalMax)
            }
            printMatrix(cache)
        }

        return globalMax * globalMax
    }

}

fun printMatrix(matrix: Array<IntArray>) {
    println("\n" + matrix.joinToString("\n") { it.joinToString(", ") } )
}

fun main() {
    val input = arrayOf(
        charArrayOf('1','0','1','0','0'),
        charArrayOf('1','0','1','1','1'),
        charArrayOf('1','1','1','1','1'),
        charArrayOf('1','0','0','1','0')
    )
    println("FOO: " + Leetcode221_maximalSquare().maximalSquare(input))
}
