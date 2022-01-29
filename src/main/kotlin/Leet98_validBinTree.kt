import java.util.*

class Leet98_validBinTree {

    var stackR = Stack<Int>()
    var stackL = Stack<Int>()

    fun isValidBST(root: TreeNode?): Boolean {
        stackR = Stack<Int>()
        return isValidBST_(root)
    }

    fun isValidBST_(root: TreeNode?): Boolean {
        if (root == null)
            return true

        if (stackR.firstOrNull { it <= root.`val` } != null) {
            println("Invalid node: $root; stackR: ${stackR.joinToString()}")
            return false
        }
        if (stackL.firstOrNull { it >= root.`val` } != null) {
            println("Invalid node: $root; stackL: ${stackL.joinToString()}")
            return false
        }

        stackR.push(root.`val`)
        if (!isValidBST_(root.left)) return false
        stackR.pop()

        stackL.push(root.`val`)
        if (!isValidBST_(root.right)) return false
        stackL.pop()

        return true
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

    println("" + Leet98_validBinTree().isValidBST(tree))
}

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
