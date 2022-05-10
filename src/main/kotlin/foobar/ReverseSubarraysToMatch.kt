package foobar

fun main(args : Array<String>) {

    val a = "1 2 3 4".split(" ").map { Integer.parseInt(it) }
    val b = "1 3 2 4".split(" ").map { Integer.parseInt(it) }

    val res = Leetcode1460().canBeEqual(a.toIntArray(), b.toIntArray())
    println("Res: $res")
}

/** 1460. Make Two Arrays Equal by Reversing Sub-arrays */
private class Leetcode1460 {

    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        val countsA = target.toTypedArray().groupingBy { it }.eachCount()
        val countsB = arr.toTypedArray().groupingBy { it }.eachCount()

        for (keyValue in countsA) {
            if (countsB[keyValue.key] != keyValue.value)
                return false
        }
        return true
    }
}
