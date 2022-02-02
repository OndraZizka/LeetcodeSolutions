package leet

class Leet94_inOrderTree {

    val list = mutableListOf<Int>()

    fun inorderTraversal(root: TreeNode?): List<Int> {
        iot(root)
        return list
    }

    fun iot(root: TreeNode?) {
        if (root == null) return
        iot(root.left)
        list.add(root.`val`)
        iot(root.right)
    }
}
