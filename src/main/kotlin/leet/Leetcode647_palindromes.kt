package leet

class Leetcode647_palindromes {


    fun countSubstrings(s: String): Int {

        val pals = mutableSetOf<Pair<Int,Int>>()

        fun isPalindrome(l: Int, r: Int): Int {
            val substring = s.substring(l, r)
            if (substring == substring.reversed()) {
                if (pals.add(l to r)) {
                    println("PAL: $l to $r - $substring")
                    return 1
                }
            }
            return 0
        }

        fun dfs(l: Int, r: Int): Int {
            if (pals.contains(l to r)) return 0
            //println("DOING $s, $l, $r ;  $r-$l > 1 ?   ${r-l > 1}")
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
    //println (Leetcode647_palindromes().countSubstrings("aaa"))
    println (Leetcode647_palindromes().countSubstrings("xkjkqlajprjwefilxgpdpebieswu"))
}
