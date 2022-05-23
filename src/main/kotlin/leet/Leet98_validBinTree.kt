package leet

import leet.Leet98_validBinTree.TreeNode

class Leet98_validBinTree {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

        constructor(v: Int, l: TreeNode?, r: TreeNode?) : this(v) {
            left = l
            right = r
        }

        override fun toString(): String {
            return "(${this.`val`}) ${left?.`val`} / ${right?.`val`}"
        }
    }



    var items = mutableListOf<Int>()

    fun isValidBST(root: TreeNode?): Boolean {
        inOrderTraversal(root)

        var prev = items.first()
        for (i in items.slice(1..(items.size - 1))) {
            if (i <= prev)
                return false
            prev = i
        }
        return true
    }

    fun inOrderTraversal(root: TreeNode?) {
        if (root == null) return

        inOrderTraversal(root.left)
        items.add(root.`val`)
        print("${root.`val`}, ")
        inOrderTraversal(root.right)
    }

}

fun main() {
    val tree = TreeNode(5,
        TreeNode(4),
        TreeNode(6,
            TreeNode(3),
            TreeNode(7)
        )
    )

    val tree1 = TreeNode(5,
        TreeNode(1),
        TreeNode(4,
            TreeNode(3),
            TreeNode(6)
        )
    )

    println("Result: " + Leet98_validBinTree().isValidBST(tree))
}
