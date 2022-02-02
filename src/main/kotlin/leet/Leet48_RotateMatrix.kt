package leet

class Leet48_RotateMatrix {

    fun rotate(matrix: Array<IntArray>): Unit {
        matrix.forEachIndexed { y, row ->
            row.forEachIndexed { x, cell ->
                matrix[y][x] = matrix[y][x] + 2000
            }
        }
        matrix.forEachIndexed { y, row ->
            row.forEachIndexed { x, cell ->
                val sourceCell = cellAtRotatedLeft(y, x, matrix) % 10000
                val stuffed = ((sourceCell) % 10000) * 10000
                matrix[y][x] = cell + stuffed
                println("[$y, $x] = $cell, + $sourceCell -> $stuffed + $cell")
            }
        }
        matrix.forEachIndexed { y, row ->
            row.forEachIndexed { x, cell ->
                matrix[y][x] = matrix[y][x] / 10000 - 2000
            }
        }
    }

    private fun cellAtRotatedLeft(y: Int, x: Int, matrix: Array<IntArray>): Int {
        val height = matrix.size
        val xRot = y
        val yRot = height-1 - x
        //println("[$y, $x] -> [$yRot, $xRot] = ${matrix[yRot][xRot]}")

        return matrix[yRot][xRot]
    }

    private fun cellAtRotatedRight(y: Int, x: Int, matrix: Array<IntArray>): Int {
        val height = matrix.size
        val yRot = x
        val xRot = height-1 - y

        return matrix[yRot][xRot]
    }
}

fun main() {
    var matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )
    matrix = arrayOf(
        intArrayOf(43,39, 3,33,37,20,14),
        intArrayOf( 9,18, 9,-1,40,22,38),
        intArrayOf(14,42, 3,23,12,14,32),
        intArrayOf(18,31,45,11, 8,-1,31),
        intArrayOf(28,44,14,23,40,24,13),
        intArrayOf(29,45,33,45,20, 0,45),
        intArrayOf(12,23,35,32,22,39, 8),
    )
    Leet48_RotateMatrix().rotate(matrix)

    println(matrix.map { it.joinToString(" ") }. joinToString("\n"))
}
//    Output:[[12,29,28,18,14,9,43],[23,45,44,30,42,18,39],[35,33,14,45,3,9,3],[32,45,23,11,23,-2,33],[22,20,40,8,12,40,37],[39,0,24,-1,14,22,20],[8,45,13,31,32,38,14]]
//  Expected:[[12,29,28,18,14,9,43],[23,45,44,31,42,18,39],[35,33,14,45,3,9,3],[32,45,23,11,23,-1,33],[22,20,40,8,12,40,37],[39,0,24,-1,14,22,20],[8,45,13,31,32,38,14]]
