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

fun createLinkedListFrom(list: List<Int>): ListNode? {
    var prev: ListNode? = null
    var head: ListNode? = null
    for (item in list) {
        val node = ListNode(item)
        if (head == null) head = node
        prev?.next = node
        prev = node
    }
    return head
}

fun ListNode?.format(): String {
    val sb = StringBuilder("[")
    var current = this
    while (current != null) {
        sb.append("${current.`val`}")
        current = current.next
        if (current != null) sb.append(", ")
    }
    sb.append("]")
    return sb.toString()
}


fun main() {
    for (input in listOf(1 to 1, 2 to 1, 5 to 2)) {
        var result = Solution().removeNthFromEnd(generateList(input.first), input.second)
        val expected = (1..input.first).filter { it != input.first - input.second + 1 }
        println("(${input.first}, ${input.second}) -> Expected: $expected. Output: " + result.format())
    }
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
        var nStepsBack: ListNode? = null

        do {
            reachedEnough++
            println("Reached: $reachedEnough; wireFrom: $wireFrom; wireTo: $wireTo; nSteps: $nStepsBack")

            if (reachedEnough == n) {
                nStepsBack = head
                wireFrom == null
                wireTo = nStepsBack?.next
            }
            if (reachedEnough > n) {
                wireFrom = nStepsBack
                nStepsBack = nStepsBack!!.next
                wireTo = nStepsBack!!.next
            }
            current = current!!.next

        } while (current != null)

        if (wireFrom == null) return head.next
        //if (wireTo == null) ...

        wireFrom?.next = wireTo
        return head
    }
}
