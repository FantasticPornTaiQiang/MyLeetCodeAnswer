import java.util.*


class Combinations {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(combine(3, 3))
        }

        fun combine(n: Int, k: Int): List<List<Int>>? {
            val res: MutableList<List<Int>> =
                ArrayList()
            if (k <= 0 || n < k) {
                return res
            }
            val path: Deque<Int> = ArrayDeque()
            dfs(n, k, 1, path, res)
            return res
        }

        private fun dfs(
            n: Int,
            k: Int,
            index: Int,
            path: Deque<Int>,
            res: MutableList<List<Int>>
        ) {
            if (path.size == k) {
                res.add(ArrayList(path))
                return
            }
            
            for (i in index..n - (k - path.size) + 1) {
                path.addLast(i)
                dfs(n, k, i + 1, path, res)
                path.removeLast()
            }
        }

    }
}