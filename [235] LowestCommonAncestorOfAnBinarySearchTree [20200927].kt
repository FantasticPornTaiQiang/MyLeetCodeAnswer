class LowestCommonAncestorOfAnBinarySearchTree {

    companion object{

        @JvmStatic
        fun main(args: Array<String>) {

        }

        private var ancestor = TreeNode()
        private var p = 0
        private var q = 0

        fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            if(root == null || p == null || q == null)
                return null
            when {
                p.`val` == q.`val` -> return p
                p.`val` > q.`val` -> {
                    this.p = q.`val`
                    this.q = p.`val`
                }
                else -> {
                    this.p = p.`val`
                    this.q = q.`val`
                }
            }
            search(root)
            return ancestor
        }

        fun search(x: TreeNode) {
            if(x.`val` in p..q) {
                ancestor = x
                return
            }
            if(p < x.`val` && q < x.`val`) {
                x.left?.let { search(it) }
            } else if (p > x.`val` && q > x.`val`) {
                x.right?.let { search(it) }
            }
        }

        class TreeNode(var `val`: Int = 0) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}