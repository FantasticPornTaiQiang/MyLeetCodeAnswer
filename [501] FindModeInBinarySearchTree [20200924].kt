class FindModeInBinarySearchTree {

    companion object{

        @JvmStatic
        fun main(args: Array<String>) {


        }

        fun findMode(root: TreeNode?): IntArray {
            val hashMap = HashMap<Int, Int>()
            root?.let { dfs(root, hashMap) }
            var max = 0
            var maxCount = 0
            for(entry in hashMap.entries) {
                if(entry.value > max) {
                    max = entry.value
                    maxCount = 1
                } else if(entry.value == max)
                    maxCount ++
            }
            val intArray = IntArray(maxCount)
            var i = 0
            for(entry in hashMap.entries) {
                if(entry.value == max) {
                    intArray[i++] = entry.key
                }
            }
            return intArray
        }

        fun dfs(x: TreeNode, hashMap: HashMap<Int, Int>) {
            x.left?.let { dfs(x.left!!, hashMap) }
            if(hashMap.containsKey(x.`val`))
                hashMap[x.`val`] = hashMap[x.`val`]!! + 1
            else
                hashMap[x.`val`] = 1
            x.right?.let { dfs(x.right!!, hashMap) }
        }

        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }

    }

}