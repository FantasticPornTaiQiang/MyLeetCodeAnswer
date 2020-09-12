import javax.print.attribute.HashPrintJobAttributeSet

class AverageOfLevelsInBinaryTree {
    companion object{

        @JvmStatic
        fun main(args: Array<String>) {

            val root = TreeNode(3)
            root.left = TreeNode(1)
            root.right = TreeNode(5)
            root.left!!.left = TreeNode(0)
            root.left!!.right = TreeNode(2)
            root.right!!.left = TreeNode(4)
            root.right!!.right = TreeNode(6)

            println(averageOfLevels(root).toList())
        }

        fun averageOfLevels(root: TreeNode?): DoubleArray {
            val averageArray = ArrayList<Double>()
            val howManyArray = IntArray(1000)

            if (root == null)
                return averageArray.toDoubleArray()

            dfs(root, 0, averageArray, howManyArray)

            return averageArray.toDoubleArray()
        }


        private fun dfs(x: TreeNode?, depth: Int, averageArray: ArrayList<Double>, howManyArray: IntArray)
        {
            if (x == null)
                return

            if(howManyArray[depth] == 0)
                averageArray.add(depth, x.`val`.toDouble())
            else {
                averageArray[depth] = (averageArray[depth] * howManyArray[depth] + x.`val`) / (howManyArray[depth] + 1)
            }
            howManyArray[depth] ++

            if (x.left != null)
                dfs(x.left, depth + 1, averageArray, howManyArray)

            if (x.right != null)
                dfs(x.right, depth + 1, averageArray, howManyArray)
        }


        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }

    }

}