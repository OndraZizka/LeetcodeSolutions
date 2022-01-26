import java.lang.StringBuilder

class Leet19//Given the head of a linked list, remove the nᵗʰ node from the end of the list
//and return its head.
//
// Example 1:
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
//
// Example 2:
//Input: head = [1], n = 1
//Output: []
//
// Example 3:
//Input: head = [1,2], n = 1
//Output: [1]
//
// Constraints:
// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Follow up: Could you do this in one pass?
// Related Topics Linked List Two Pointers 👍 8503 👎 407

fun generateList(n: Int): ListNode {
    val head = ListNode(1)
    var current = head

    (2..n).forEach {
        current.next = ListNode(it)
        current = current.next!!
    }
    return head
}

fun main() {
    val result = Solution().removeNthFromEnd(generateList(2), 1)

    println("Output: " + formatLinkedList(result))
}

private fun formatLinkedList(list: ListNode?): String {
    val sb = StringBuilder("[")
    var current = list
    while (current != null) {
        sb.append("${current.`val`}")
        current = current.next
    }
    sb.append("]")
    return sb.toString()
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString() = this.`val`.toString()
}

//   A -> [B] -> C -> D

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        var current: ListNode? = head ?: return null

        var reachedEnough = 0
        var wireFrom: ListNode? = null
        var wireTo: ListNode? = null
        var nStepsBack = current!!

        do {
            println("Reached: $reachedEnough; wireFrom: $wireFrom; wireTo: $wireTo; nSteps: $nStepsBack")
            if (reachedEnough == n) {
                wireFrom = nStepsBack
                wireTo = nStepsBack.next!!.next ?: return null
                nStepsBack = nStepsBack.next!!
            }
            else reachedEnough++
            current = current!!.next
        } while (current != null)

        if (reachedEnough != n)
            return null

        if (wireFrom == null && wireTo == null)
            return null

        wireFrom?.next = wireTo
        return head
    }
}
