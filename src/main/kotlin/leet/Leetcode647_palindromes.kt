package leet

class Leetcode647_palindromes {
    fun countSubstrings(s: String): Int {

        var palCount = s.length

        for (middle in s.indices) {
            println("*** $middle")
            var delta = 1
            while (middle-delta >= 0 && middle+delta < s.length ) {
                if (s[middle-delta] != s[middle+delta]) break
                println("  $delta > " + s.substring(middle-delta..middle+delta))
                palCount++
                delta++
            }
            if (middle < 1) continue

            delta = 1
            while (middle-delta >= 0 && middle+delta-1 < s.length ) {
                if (s[middle-delta] != s[middle+delta-1]) break
                println("  _$delta > " + s.substring(middle-delta..middle+delta-1))
                palCount++
                delta++
            }
        }

        return palCount
    }
}

fun main() {
    //println (Leetcode647_palindromes().countSubstrings("abc"))
    println (Leetcode647_palindromes().countSubstrings("aaa"))
    //println (Leetcode647_palindromes().countSubstrings("xkjkqlajprjwefilxgpdpebieswu"))
}
