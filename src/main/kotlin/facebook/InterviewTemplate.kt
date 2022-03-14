package facebook

class Task01 {

    fun solve(numbers: List<Int>) {

    }

}

fun main() {
    val ints = parseInts("[0]")
    Task01().solve(ints)
}

fun parseInts(str: String) = str.removePrefix("[").removeSuffix("]").splitToSequence(",").map { it.toInt() }.toList()
