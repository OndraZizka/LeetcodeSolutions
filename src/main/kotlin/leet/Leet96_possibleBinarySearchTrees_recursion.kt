package leet

class Leet96_possibleBinarySearchTrees_recursion {

    fun numTrees(n: Int): Int {
        return numTree(n)
    }

    val cache = IntArray(50) // (0..50).map { null }.toList()


    fun numTree(n: Int) : Int {
        if (n == 0) return 1
        if (n == 1) return 1
        if (n == 2) return 2
        if (n == 3) return 5

        if (cache[n] != 0)
            return cache[n]

        var total = 0
        for (i in 0..n-1) {
            val nodesAtLeft = i
            val nodesAtRight = n-1 - i

            val treesAtLeft = numTree(nodesAtLeft)
            val treesAtRight = numTree(nodesAtRight)
            total += treesAtLeft * treesAtRight
        }
        cache[n] = total
        return total
    }

}

fun main() {
    val res = Leet96_possibleBinarySearchTrees_recursion().numTrees(4)
    println("$res")
}
