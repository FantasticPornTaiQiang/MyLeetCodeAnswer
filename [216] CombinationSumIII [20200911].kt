class CombinationSumIII {

    companion object{

        @JvmStatic
        fun main(args: Array<String>) {
            println(combinationSum3(3, 9))
        }

        fun combinationSum3(k: Int, n: Int): List<List<Int>> {
            val outputList = ArrayList<List<Int>>()
            for(i in 1..9) {
                val output = ArrayList<Int>()
                recurse(i, 0, n, k, output, outputList)
            }
            return outputList
        }

        private fun recurse(startNum: Int, nowSum: Int, n: Int, k: Int, output: ArrayList<Int>, outputList: ArrayList<List<Int>>) {
            var num = startNum
            var sum = nowSum
            output.add(num)
            sum += num

            while(num <= 8 && output.size <= k - 1) {
                val nextSum = num + 1 + sum
                if(nextSum > n) return
                if(nextSum == n && output.size == k - 1) {
                    output.add(num + 1)
                    outputList.add(ArrayList<Int>(output))
                    output.removeAt(k - 1)
                } else if (nextSum < n){
                    recurse(num + 1, sum, n, k, output, outputList)
                    output.removeAt(output.size - 1)
                }
                num ++
            }
        }


    }
}