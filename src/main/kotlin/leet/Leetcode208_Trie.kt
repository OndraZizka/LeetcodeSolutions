package leet

class Leetcode208_Trie  {

    data class Node(
        val char: Char,
        val nextChar: Array<Node?> = Array(27) { null },
        var terminal: Boolean = false
    ) {
        override fun toString() = "($char)"
    }

    private val baseOffset = 'a'.toInt()
    private val root = Node('^')

    fun insert(word: String) {

        var curNode = root
        for (char in word) {
            val index = char.toInt() - baseOffset
            var nextNode: Node? = curNode.nextChar.get(index)
            if (nextNode == null) {
                nextNode = Node(char)
                 curNode.nextChar.set(index, nextNode)
            }
            curNode = nextNode
        }
        curNode.terminal = true
    }

    fun search(word: String): Boolean {
        var curNode = root
        for (char in word) {
            val index = char.toInt() - baseOffset
            var nextNode: Node? = curNode.nextChar.get(index)
            if (nextNode == null) return false
            curNode = nextNode
        }
        //return curNode.nextChar[0] != null
        return curNode.terminal
    }

    fun startsWith(prefix: String): Boolean {
        var curNode = root
        for (char in prefix) {
            val index = char.toInt() - baseOffset
            var nextNode: Node? = curNode.nextChar.get(index)
            if (nextNode == null) return false
            curNode = nextNode
        }
        return true
    }

}

fun main() {
    val trie = Leetcode208_Trie()
    println(
        listOf(
            trie.insert("apple")
            ,trie.search("apple")
            ,trie.search("app")
            ,trie.startsWith("app")
            ,trie.insert("app")
            ,trie.search("app")
        ).joinToString(", ")
    )
    // Expected [null,true,false,true,null,true]
}
