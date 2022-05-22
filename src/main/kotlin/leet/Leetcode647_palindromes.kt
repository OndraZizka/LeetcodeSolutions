package leet

class Leetcode647_palindromes {


    fun countSubstrings(s: String): Int {

        val pals = mutableSetOf<String>()

        fun isPalindrome(l: Int, r: Int): Int {
            val substring = s.substring(l, r)
            if (substring == substring.reversed()) {
                if (pals.add(substring)) {
                    println("PAL: $substring")
                    return 1
                }
            }
            return 0
        }

        fun dfs(l: Int, r: Int): Int {
            println("DOING $s, $l, $r ;  $r-$l > 1 ?   ${r-l > 1}")
            var palCount = isPalindrome(l, r)
            if (r-l > 1) {
                palCount += dfs(l + 1, r) + dfs(l, r - 1)
            }

            return palCount
        }

        return dfs(0, s.length)
    }
}

fun main() {
    //println (Leetcode647_palindromes().countSubstrings("abc"))
    println (Leetcode647_palindromes().countSubstrings("aaa"))
}
