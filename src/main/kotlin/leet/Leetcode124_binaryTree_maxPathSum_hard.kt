package leet

class Leetcode124_binaryTree_maxPathSum_hard {

    class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
    }

    fun maxPathSum(root: TreeNode?): Int {

        var globalMax = Integer.MIN_VALUE

        fun dfs (node: TreeNode?): Int {
            if (node == null) return 0

            val lMax = dfs(node.left)
            val rMax = dfs(node.right)

            val withBoth = maxOf(lMax, 0) + maxOf(rMax, 0) + node.`val`
            val justOne =  maxOf(maxOf(lMax, 0), maxOf(rMax, 0)) + node.`val`

            globalMax = maxOf(globalMax, withBoth, justOne)

            return justOne
        }

        dfs(root)

        return globalMax
    }
}
