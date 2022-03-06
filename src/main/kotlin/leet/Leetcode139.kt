package leet

class Leetcode139 {

    fun wordBreak(s: String, wordDict: List<String>): Boolean {

        val wordDict = wordDict.sortedBy { -it.length }

        val dpTable = List<Boolean?>(s.length +1) {null}.toMutableList()
        dpTable[s.length] = true

        fun subproblem(pos: Int): Boolean {
            //val pad = "  ".repeat(pos)
            //println("$pad Sub: pos $pos")
            if (pos == s.length) {
                //println("$pad FOUND")
                return true
            }
            if (dpTable[pos] != null) {
                //println("$pad DP at $pos == ${dpTable[pos]}")
                return dpTable[pos]!!
            }

            for (word in wordDict) {
                //println("$pad Trying: $word")
                if (!s.substring(pos).startsWith(word)) continue

                val nextPos = pos + word.length
                if (nextPos > s.length) continue

                val isBuildable = subproblem(nextPos)
                if (isBuildable){
                    //println("$pad Setting buildable = TRUE at $pos")
                    dpTable.set(pos, true)
                    return true
                }

            }
            //println("$pad Setting buildable = FALSE at $pos")
            dpTable.set(pos, false)
            return false
        }

        return subproblem(0)
    }

}

fun main() {
    val res = Leetcode139().wordBreak(
        //"foobar", listOf("foo", "bax")
        //"aaaaaaa", listOf("aaaa","aa")
        //"abcd", listOf("a","abc","b","cd")
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", listOf("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")
    )
    //println("Res: $res")
}
