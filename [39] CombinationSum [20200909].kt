class CombinationSum {

    companion object{

        @JvmStatic
        fun main(args: Array<String>) {
            val array = intArrayOf(1,2)
            println(combinationSum(array, 4))
        }

        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
            val sortedCandidates = candidates.sorted()
            val outputList = ArrayList<List<Int>>()

            val nowTargetIndex = sortedCandidates.size - 1

            recurse(target, nowTargetIndex, outputList, sortedCandidates, true)

            return outputList
        }

        private var output = ArrayList<Int>()

        private fun recurse(target: Int, startIndex: Int, outputList: ArrayList<List<Int>>, sortedCandidates: List<Int>, isFirstRecurse: Boolean) {
            var index = startIndex
            while(index >= 0) {
                if(isFirstRecurse) output = ArrayList()
                if(sortedCandidates[index] > target) {
                    index--
                    continue
                }

                val difference = target - sortedCandidates[index]
                if(difference == 0) {
                    output.add(sortedCandidates[index])
                    outputList.add(ArrayList<Int>(output))
                    output.removeAt(output.size - 1)
                } else if (difference >= sortedCandidates[0]) {
                    output.add(sortedCandidates[index])
                    val outputTemp = ArrayList<Int>(output)
                    recurse(difference, index, outputList, sortedCandidates, false)
                    output = outputTemp
                    output.removeAt(output.size - 1)
                }

                index --
            }
        }

    }

}