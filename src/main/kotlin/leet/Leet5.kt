package leet

class Leet5 {

    fun longestPalindrome(s: String): String {

        val maxIndex = s.length-1
        var longest = ""
        var maxLen = 0
        var pos = 0

        for (c in s) {
            // Odd
            var offset = 0
            while (offset <= pos && offset <= maxIndex - pos) {
                if (s[pos - offset] != s[pos + offset])
                    break;

                val curPalLen = 1 + 2 * offset
                if (curPalLen > maxLen) {
                    maxLen = curPalLen
                    longest = s.substring(pos - offset, pos + offset +1)
                }
                offset++
            }

            // Even
            if (pos != maxIndex && s[pos] == s[pos+1]) {
                offset = 0
                while (offset <= pos && 1 + offset <= maxIndex - pos) {
                    if (s[pos - offset] != s[pos +1 + offset])
                        break;

                    val curPalLen = 2 + 2* offset
                    if (curPalLen > maxLen) {
                        maxLen = curPalLen
                        longest = s.substring(pos - offset, pos +1 + offset +1)
                    }
                    offset++
                }
            }

            pos++
        }

        return longest
    }

}

fun main() {
    for (i in listOf(
//        "" to "",
        "a" to "a",
//        "aa" to "aa",
//        "aab" to "aa",
//        "abb" to "bb",
//        "aabb" to "aa",
//        "aacbb" to "aa",
//        "aaccbb" to "aa",
//        "aacccbb" to "ccc",
//        "aaaaa1" to "aaaaa",
//        "aa1aa" to "aa1aa",
    )) {
        println("Trying ${i.first}")
        val res = Leet5().longestPalindrome(i.first)
        print("${i.first} => $res")
        if (res != i.second) print("; EXPECTED ${i.second}") else print("  ...OK")
        println()
    }
}
