package leet

class LeetCode102_BfsTreeTraversal {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {

        val res = mutableListOf<List<Int>>()
        var curLevelList = mutableListOf<Int>()
        if (root == null) return res

        var q = ArrayDeque<TreeNode>().apply { add(root!!) }
        var tmpQ = ArrayDeque<TreeNode>()

        while (q.isNotEmpty()) {
            q.forEach {
                curLevelList.add(it.`val`)
                it.left?.let { tmpQ.add(it) }
                it.right?.let { tmpQ.add(it) }
            }
            res.add(curLevelList)

            if (tmpQ.isEmpty())  break
            curLevelList = mutableListOf()
            q.clear()
            q.addAll(tmpQ)
            tmpQ.clear()
        }
        return res.reversed()
    }

}

fun main() {
    val root = LeetCode102_BfsTreeTraversal.TreeNode(1)
    root.left = LeetCode102_BfsTreeTraversal.TreeNode(2)
    root.right = LeetCode102_BfsTreeTraversal.TreeNode(3)

    val res = LeetCode102_BfsTreeTraversal().levelOrder( root ).reversed()
}
