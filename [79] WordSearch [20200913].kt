class WordSearch {
    companion object{

        @JvmStatic
        fun main(args: Array<String>) {
            val array = arrayOf(charArrayOf('A','B','C','E'), charArrayOf('S','F','C','S'), charArrayOf('A','D','E','E'))
            println(exist(array, "ABCB"))

        }

        private var height = 0
        private var width = 0
        private var k = 0
        private var word = ""

        fun exist(board: Array<CharArray>, word: String): Boolean {
            height = board.size
            width = board[0].size
            this.word = word
            val isSelected = Array(height){BooleanArray(width)}

            for (i in 0 until height) {
                for (j in 0 until width) {
                    if(board[i][j] == word[0]){
                        isSelected[i][j] = true
                        k = 1
                        if(!search(i, j, board, isSelected))
                            isSelected[i][j] = false
                        else
                            return true
                    }
                }
            }
            return false
        }

        //比较word[k]和board[i][j]周围的可选元素board[i1][j1]是否相等，如果找不到相等的，则返回false，如果找得到
        //则将isSelected[i1][j1]置true，继续比较word[k+1]与board[i1][j1]周围可选元素是否相等
        fun search(i: Int, j: Int, board: Array<CharArray>, isSelected: Array<BooleanArray>): Boolean {
            if(k == word.length)
                return true
            //对比右边一个元素
            if(j < width - 1 && !isSelected[i][j + 1] && board[i][j + 1] == word[k]) {
                isSelected[i][j + 1] = true
                k++
                if(!search(i, j + 1, board, isSelected)) {
                    isSelected[i][j + 1] = false
                    k--
                }
                else
                    return true
            }
            //对比下面一个元素
            if (i < height - 1 && !isSelected[i + 1][j] && board[i + 1][j] == word[k]) {
                isSelected[i + 1][j] = true
                k++
                if(!search(i + 1, j, board, isSelected)) {
                    isSelected[i + 1][j] = false
                    k--
                }
                else
                    return true
            }
            //对比上面一个元素
            if (i > 0 && !isSelected[i - 1][j] && board[i - 1][j] == word[k]) {
                isSelected[i - 1][j] = true
                k++
                if(!search(i - 1, j, board, isSelected)) {
                    isSelected[i - 1][j] = false
                    k--
                }
                else
                    return true
            }
            //对比左边一个元素
            if (j > 0 && !isSelected[i][j - 1] && board[i][j - 1] == word[k]) {
                isSelected[i][j - 1] = true
                k++
                if(!search(i, j - 1, board, isSelected)) {
                    isSelected[i][j - 1] = false
                    k--
                }
                else
                    return true
            }
            return false
        }
    }
}










