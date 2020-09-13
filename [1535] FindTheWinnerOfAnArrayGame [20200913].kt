class FindTheWinnerOfAnArrayGame {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val arr = intArrayOf(1,9,8,2,3,7,6,4,5)
            println(getWinner(arr, 7))
        }

        /**
        说明：
        1. k1为计数器，从k逐渐减至0，每当array[0]发生变化，则k1应重置
        2. 对于判定为被大于的数，直接剔除

        设计程序循环如下：
        对于当前的array[0]
        如果右边仍有数，比较array[0]和array[1]，剔除更小的那个数。同时如果array[1]更小，则k1--，如果array[0]更小，则k1=k-1
        进入下一轮，继续判断array[0]

        胜利条件（满足任一即可）：
        1. 该数右边还有数字，但k1已经为0，则该数胜利
        2. 该数右边已经没有数字，且k1>=0，则该数必赢
        */
        fun getWinner(arr: IntArray, k: Int): Int {
            val numList: ArrayList<Int> = arr.toList() as ArrayList<Int>
            var k1 = k

            while(numList.size > 1) {
                if(numList[0] < numList[1]) {
                    numList.removeAt(0)
                    k1 = k - 1
                } else if (numList[0] > numList[1]) {
                    numList.removeAt(1)
                    k1 --
                }
                if(k1 == 0) {
                    return numList[0]
                }
            }

            return numList[0]
        }

        //改进思路：直接进行交换！避免掉生成list及删除
        fun getWinnerPorn(a: IntArray, k: Int): Int {
            var win = 0

            for (i in 1 until a.size) {
                if (a[0] > a[i]) {
                    win++
                } else {
                    win = 1
                    a[0] = a[i].also { a[i] = a[0] }
                }

                if (win == k) break
            }

            return a[0]

        }
    }
}