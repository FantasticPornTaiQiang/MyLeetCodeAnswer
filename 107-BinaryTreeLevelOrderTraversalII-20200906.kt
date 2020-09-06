import kotlin.collections.ArrayList

class BinaryTreeLevelOrderTraversalII {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val root = null
            println(levelOrderBottom(root))
        }

        private fun levelOrderBottom(root : TreeNode?) : List<List<Int>> {
            val treeLevelOrderList = ArrayList<List<Int>>()
            if (root == null) {
                return treeLevelOrderList
            }
            val treeNodeQueue = TreeNodeQueue()
            treeNodeQueue.push(root)
            while (!treeNodeQueue.isEmpty()) {
                val levelList = ArrayList<Int>()
                for (i in 0 until treeNodeQueue.size) {
                    val node = treeNodeQueue.pop()
                    levelList.add(node.`val`)
                    if (node.left != null) {
                        treeNodeQueue.push(node.left!!)
                    }
                    if (node.right != null) {
                        treeNodeQueue.push(node.right!!)
                    }
                }
                treeLevelOrderList.add(0, levelList)
            }
            return treeLevelOrderList
        }

        class TreeNodeQueue {
            private val queue = ArrayList<TreeNode>()

            var size = 0

            fun pop() : TreeNode {
                size --
                return queue.removeAt(0)
            }

            fun push(x : TreeNode) {
                size ++
                queue.add(x)
            }

            fun isEmpty(): Boolean {
                return size == 0
            }
        }

        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }

    }
}