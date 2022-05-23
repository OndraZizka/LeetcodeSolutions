package leet

class LeetCode107_Tree_reversedLevelOrder {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        return LeetCode102_BfsTreeTraversal().levelOrder(root).reversed()
    }
}
