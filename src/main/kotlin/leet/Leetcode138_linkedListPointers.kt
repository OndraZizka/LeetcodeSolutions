package leet

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
    override fun toString(): String {
        return "(${`val`}) --> $random "
    }
}

class Leetcode138_linkedListPointers {

    fun copyRandomList(node: Node?): Node? {

        if (node == null) return null

        var i = 0
        var curReadNode: Node = node
        val readToWriteNodes = hashMapOf<Node, Node>()

        val resultHead = Node(curReadNode.`val`)
        var curWriteNode = resultHead
        val todo = mutableListOf<Node>()

        while (curReadNode != null) {

            // Mapping from input to result nodes.
            readToWriteNodes.put(curReadNode, curWriteNode)

            val curReadRandom = curReadNode.random
            if (curReadRandom != null) {
                // If we already created the new one, link to it through `random` and remove.
                readToWriteNodes.get(curReadRandom)
                    ?.also { curWriteNode.random = it }
                    ?: let { todo.add(curReadNode) }
            }
            if (curReadNode.next == null)
                break

            curWriteNode.next = Node(curReadNode.next!!.`val`)
            curReadNode = curReadNode.next!!
            curWriteNode = curWriteNode.next!!
            i++
        }

        for (remainingReadNodeWithRandom in todo) {
            val fromWrite = readToWriteNodes.get(remainingReadNodeWithRandom)
            val toWrite = readToWriteNodes.get(remainingReadNodeWithRandom.random)
            fromWrite ?.random = toWrite
        }

        return resultHead
    }

}
