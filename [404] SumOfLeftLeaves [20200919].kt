class SumOfLeftLeaves {
    companion object{

        @JvmStatic
        fun main(args: Array<String>) {

        }

        private var sum = 0

        fun sumOfLeftLeaves(root: TreeNode?): Int {
            if(root == null) return sum
            traversal(root)
            return sum
        }


        fun traversal(x: TreeNode){
            x.left?.let {
                if(it.left == null && it.right == null) {
                    sum += it.`val`
                } else {
                    traversal(it)
                }
            }
            x.right?.let { traversal(it) }
        }

        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }

    }
}