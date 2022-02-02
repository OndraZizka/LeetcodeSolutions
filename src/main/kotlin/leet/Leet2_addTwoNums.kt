package leet

import kotlin.streams.toList

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var li = leet.ListNode(5)
 * var v = li.`val`
 */
class Leet2_addTwoNums {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var keep = 0
        var cur1 = l1
        var cur2 = l2

        val resHead = ListNode(-1)
        var resCur = resHead

        while (true) {
            val val1 = cur1?.`val` ?: 0
            val val2 = cur2?.`val` ?: 0
            val res = val1 + val2 + keep
            if (res > 9) keep = (res / 10) else keep = 0
            cur1 = cur1?.next
            cur2 = cur2?.next
            resCur.`val` = res % 10
            if (cur1 == null && cur2 == null && keep == 0) break
            resCur.next = ListNode(-1)
            resCur = resCur.next!!
        }
        return resHead
    }
}

fun main(){
    val a = createLinkedListFrom(listOf(2, 4, 3))
    val b = createLinkedListFrom(listOf(5, 6, 4))
    val res = Leet2_addTwoNums().addTwoNumbers(a, b)
    println("${a.format()} + ${b.format()} -> ${res.format()}")

    fun perform(a: String, b: String, expected: String) {
        val aAsInts = a.filter { it.isDigit() }.chars().map{ it -> it - '0'.code }.toList()
        val bAsInts = b.filter { it.isDigit() }.chars().map{ it -> it - '0'.code }.toList()
        val aLinked = createLinkedListFrom(aAsInts)
        val bLinked = createLinkedListFrom(bAsInts)
        val exp = createLinkedListFrom(expected.filter { it.isDigit() }.chars().map{ it -> it - '0'.code }.toList())

        val res = Leet2_addTwoNums().addTwoNumbers(aLinked, bLinked)
        println("${aLinked.format()} + ${bLinked.format()} -> ${res.format()}, expected: ${exp.format()}")
    }

    perform("9,9,9,9,9,9,9", "9,9,9,9", "8,9,9,9,0,0,0,1")
}
