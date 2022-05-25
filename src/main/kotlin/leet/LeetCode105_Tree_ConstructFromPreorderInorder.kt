package leet

import java.util.*

class LeetCode105_Tree_ConstructFromPreorderInorder {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
        override fun toString(): String {
            return "(${this.`val`} -> ${this.left?.`val`}, ${this.right?.`val`})"
        }
    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) return null

        var curI = 0
        val root = TreeNode(preorder[0])
        val stack = Stack<Int>().apply { this.add(preorder[0]) }
        var curP = 1

        fun hasNext() = curI < inorder.size && curP < preorder.size
        fun nextInorder() = if (curI >= inorder.size) null else inorder[curI]
        fun stackPeekOrNull() =  if (stack.isEmpty()) null else stack.peek()

        fun dfs(curNode: TreeNode) {

            if (hasNext() && nextInorder() != curNode.`val`) {
                curNode.left = TreeNode(preorder[curP++])
                stack.push(curNode.left!!.`val`)
                dfs(curNode.left!!)
            }
            if (nextInorder() == curNode.`val`) {
                curI++
                stack.pop()
                if (curI >= inorder.size) return
            }
            if (nextInorder() == stackPeekOrNull()) {
                return
            }
            if (nextInorder() != curNode.`val` && nextInorder() != stackPeekOrNull()) {
                curNode.right = TreeNode(preorder[curP++])
                stack.push(curNode.right!!.`val`)
                dfs(curNode.right!!)
            }
        }

        dfs(root)

        return root
    }
}

fun main() {
    //LeetCode105_Tree_ConstructFromPreorderInorder().buildTree(intArrayOf(3,9,20,15,7), intArrayOf(9,3,15,20,7))
    //LeetCode105_Tree_ConstructFromPreorderInorder().buildTree(intArrayOf(1,2,3), intArrayOf(2,3,1))
    LeetCode105_Tree_ConstructFromPreorderInorder().buildTree(intArrayOf(3,1,2,4), intArrayOf(1,2,3,4)) // Exp.  3 / 1,4 / null / 2
}
