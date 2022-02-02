package leet

fun main() {
    for (i in listOf(
        "abcabcabcda" to 4,
        "aaaaaaaaab" to 2,
        "a" to 1,
        "aaabbbccc123" to "4"
    )) {
        val len = Leet3_substringNoRecurringChars().lengthOfLongestSubstring(i.first)
        println("${i.first} -> $len, expected ${i.second}")
    }
}

class Leet3_substringNoRecurringChars {
    fun lengthOfLongestSubstring(s: String): Int {
        println("\nSolving: $s")
        val counts = IntArray(128)
        counts.fill(0)
        var maxLen = 0
        var curLen = 0
        var curStart = s
        var startPos = 0 // In sync with the above.

        for (c in s) {
            //if (c.code > 127) throw Error("Unexpected input char range: $c in $s")
            val addedCharCode = c.toInt()
            val prevCount = counts[addedCharCode]

            counts[addedCharCode]++
            curLen++

            if (prevCount == 0) {
                if (curLen > maxLen) maxLen = curLen
            }
            else {
                print("      ")
                while (true) {
                    curStart = s.substring(startPos)
                    val removedCharCode = curStart.first().toInt() // Kotlin 1.5: code
                    counts[removedCharCode]--
                    print("$removedCharCode--, ")

                    startPos++
                    curLen--
                    if (curLen == 0) break

                    if (removedCharCode == addedCharCode)
                        break
                }
                println()
            }
            println("  $c -> $addedCharCode, currently ${counts[addedCharCode]}; curLen: ${curLen.toString().padStart(3)}; startPos: $startPos; ${formatCounts(counts)}")
        }
        return maxLen
    }

    private fun formatCounts(counts: IntArray): String {
        return counts/*.slice(32..127)*/.mapIndexed { index, i -> if (i == 0) null else "${index.toChar()}:$i" }.filterNotNull().joinToString(", ")
    }
}
