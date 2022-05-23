package leet

class Leetcode13_RomanToInteger {

    val conv = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000,
    )

    fun romanToInt(s: String): Int {

        var int = 0

        var lastVal = 0

        for (c in s) {
            val curVal = conv[c]!!
            int += curVal
            if (lastVal < curVal)
                int -= lastVal shl 1
            lastVal = curVal
        }

        return int
    }

}
