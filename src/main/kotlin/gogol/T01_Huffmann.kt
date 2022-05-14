package gogol

import kotlin.collections.ArrayDeque

class T01_Huffmann {

    class Node(var a: Node? = null, var b: Node? = null, var value: Char? = null) {
        override fun toString(): String {
            return "($value)"
        }
        fun toTreeString(level: Int = 0): String {
            return "\n($value)\n${level+1}:   ${a?.toTreeString(level + 1)} | ${b?.toTreeString(level + 1)}"
        }
    }


    fun buildTree(dict: Map<Char, Int>): Node {

        val byLevel: Map<Int, ArrayDeque<Char>> =
            dict.entries.groupBy( { it.value }, {it.key} ).toSortedMap()
            .mapValues { entry -> ArrayDeque(entry.value.sorted()) }

        var deepestLevel: Int = byLevel.keys.last()

        val root = Node()

        var curLevel = 0

        fun dfs(curNode: Node) {

            if (curLevel == deepestLevel && byLevel[curLevel]!!.isEmpty()) {
                deepestLevel--
                return
            }


            val anythingDeeper = deepestLevel > curLevel //byLevel[curLevel + 1]?.isEmpty() ?: true

            if (anythingDeeper) {
                curLevel++
                curNode.a = Node()
                dfs(curNode.a!!)
                curNode.b = Node()
                dfs(curNode.b!!)
                curLevel--
            }
            else {
                val curLevelDone = byLevel[curLevel]?.isEmpty() ?: true
                if (!curLevelDone)
                    curNode.value = byLevel[curLevel]!!.removeFirst()
            }
        }

        dfs(root)

        return root
    }

    fun printTree(root: Node) {
        var q = ArrayDeque<Node>().apply { add(root) }
        var tmp = ArrayDeque<Node>()

        while (q.isNotEmpty()) {
            q.forEach {
                print("$it | ")
                it.a?.let { tmp.add(it) }
                it.b?.let { tmp.add(it) }
            }
            println()
            q.clear()
            q.addAll(tmp)
            tmp.clear()
        }
    }
}

fun main() {
    val dict = mapOf<Char, Int>('a' to 2, 'b' to 2, 'c' to 2, 'd' to 2)
    val t01Huffmann = T01_Huffmann()
    val tree = t01Huffmann.buildTree(dict)
    //println(tree.toTreeString())
    t01Huffmann.printTree(tree)
}
