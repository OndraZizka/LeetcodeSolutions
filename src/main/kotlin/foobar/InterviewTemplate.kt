package foobar

private class Task01 {

    fun solve(numbers: List<Int>) {

    }

}

fun main() {
    val ints = parseInts("[0]")
    Task01().solve(ints)
}

fun parseInts(str: String) = str.removePrefix("[").removeSuffix("]").splitToSequence(",").map { it.toInt() }.toList()

val directions4 = "0 1, 1 0, -1 0, 0 -1"
