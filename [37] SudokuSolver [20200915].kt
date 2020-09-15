class SudokuSolver {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
//            val array = arrayOf(
//                  charArrayOf('5','3','.','.','7','.','.','.','.')
//                , charArrayOf('6','.','.','1','9','5','.','.','.')
//                , charArrayOf('.','9','8','.','.','.','.','6','.')
//                , charArrayOf('8','.','.','.','6','.','.','.','3')
//                , charArrayOf('4','.','.','8','.','3','.','.','1')
//                , charArrayOf('7','.','.','.','2','.','.','.','6')
//                , charArrayOf('.','6','.','.','.','.','2','8','.')
//                , charArrayOf('.','.','.','4','1','9','.','.','5')
//                , charArrayOf('.','.','.','.','8','.','.','7','9'))
//            solveSudoku(array)
        }

        private val row = IntArray(9)
        private val column = IntArray(9)
        private val palace = Array(3){IntArray(3)}


        fun solveSudoku(board: Array<CharArray>) {
            dfs(board, init(board))
        }

        private fun dfs(board: Array<CharArray>, count: Int): Boolean {
            if(count == 0)
                return true

            val spacePosition = getSpacePosition(board)
            val possibleNum = getPossibleNum(spacePosition[0], spacePosition[1])
            for(i in 0 until 9) {
                if(testBit(possibleNum, i + 1)) {
                    updateState(spacePosition[0], spacePosition[1], i, board, true)
                    if(dfs(board, count - 1)) return true
                    updateState(spacePosition[0], spacePosition[1], i, board, false)
                }
            }
            return false
        }

        private fun updateState(x: Int, y: Int, bit: Int, board: Array<CharArray>, what: Boolean) {
            if(what) {
                row[x] = row[x].shr(bit).or(1).shl(bit).or(row[x])
                column[y] = column[y].shr(bit).or(1).shl(bit).or(column[y])
                palace[x / 3][y / 3] = palace[x / 3][y / 3].shr(bit).or(1).shl(bit).or(palace[x / 3][y / 3])
                board[x][y] = (bit + 49).toChar()
            } else {
                row[x] = row[x].shr(bit).and(0).shl(bit).or(row[x])
                column[y] = column[y].shr(bit).and(0).shl(bit).or(column[y])
                palace[x / 3][y / 3] = palace[x / 3][y / 3].shr(bit).and(0).shl(bit).or(palace[x / 3][y / 3])
                board[x][y] = '.'
            }
        }

        private fun getSpacePosition(board: Array<CharArray>): IntArray {
            val spacePosition = IntArray(2)
            var minCount = 10
            for(i in 0 until 9) {
                for(j in 0 until 9) {
                    if(board[i][j] == '.') {
                        val usableCount = oneBitCount(getPossibleNum(i, j))
                        if(usableCount < minCount) {
                            minCount = usableCount
                            spacePosition[0] = i
                            spacePosition[1] = j
                        }
                    }
                }
            }
            return spacePosition
        }

        private fun getPossibleNum(x: Int, y: Int): Int {
            return (row[x] or (column[y]) or (palace[x / 3][y / 3])).inv().and(511)
        }

        private fun init(board: Array<CharArray>): Int {
            var count = 0
            for(i in 0 until 9) {
                for(j in 0 until 9){
                    if(board[i][j] != '.') {
                        val n: Int = board[i][j] - '1'
                        row[i] = row[i].or(1.shl(n))
                        column[j] = column[j].or(1.shl(n))
                        palace[i / 3][j / 3] = palace[i / 3][j / 3].or(1.shl(n))
                    } else {
                        count ++
                    }
                }
            }
            return count
        }

        private fun oneBitCount(i1: Int): Int {
            var i = i1
            i -= i ushr 1 and 1431655765
            i = (i and 858993459) + (i ushr 2 and 858993459)
            i = i + (i ushr 4) and 252645135
            i += i ushr 8
            i += i ushr 16
            return i and 63
        }

        private fun testBit(n: Int, bit: Int): Boolean {
            return n.shr(bit - 1).and(1) == 1
        }

    }

}
