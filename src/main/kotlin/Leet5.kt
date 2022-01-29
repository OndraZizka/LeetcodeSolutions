import java.util.*

class Leet5 {

    class Context {
        val palindromes = mutableMapOf<IntRange, Boolean>()
        val lettersPos = mutableMapOf<Char, TreeSet<Int>>()
    }


    fun longestPalindrome(s: String): String {

        val ctx = Context()
        s.forEachIndexed { i, c ->
            ctx.lettersPos.computeIfAbsent(c) { TreeSet() }.add(i)
        }

        var longest = s
        var maxLen = 1
        var pos = 0

        for (c in s) {
            for (otherPos in ctx.lettersPos.get(c)!!.tailSet(pos+1)) {
                if (isPalindrome(s, pos, otherPos, ctx) == true) {
                    longest = s.substring(pos, otherPos)
                    maxLen = otherPos - pos
                }
            }
            pos++
        }

    }

    private fun isPalindrome(s: String, pos: Int, otherPos: Int, ctx: Context, ): Boolean {
        // Assumes the equality of the edges chars was already checked.

        if (pos == otherPos) return true
        if (pos == otherPos - 3) return true

        if (true == ctx.palindromes.get(pos..otherPos)) return true

        var offset = 1
        while (offset < (otherPos - pos) / 2) {
            if (s[pos+offset] != s[otherPos-offset])
                TODO()
        }

    }

}
