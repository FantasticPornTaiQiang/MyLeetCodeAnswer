import kotlin.math.min

class CombinationSumII {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val array = intArrayOf(3,1,3,5,1,1)
            println(combinationSum2(array, 8))
        }

        fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
            val sortedCandidates = candidates.sorted()
            val outputList = ArrayList<List<Int>>()

            val nowTargetIndex = sortedCandidates.size - 1

            recurse(target, nowTargetIndex, outputList, sortedCandidates, true)

            val outputSet = outputList.toSet()
            return outputSet.toList()
        }

        private var output = ArrayList<Int>()
        private var isSelect = BooleanArray(0)

        private fun recurse(target: Int, startIndex: Int, outputList: ArrayList<List<Int>>, sortedCandidates: List<Int>, isFirstRecurse: Boolean) {
            var index = startIndex
            while(index >= 0) {
                if(isFirstRecurse) {
                    output = ArrayList()
                    isSelect = BooleanArray(sortedCandidates.size)
                }
                if(sortedCandidates[index] > target) {
                    index--
                    continue
                }

                if(isSelect[index]) {
                    index--
                    continue
                }

                val difference = target - sortedCandidates[index]
                if(difference == 0) {
                    isSelect[index] = true
                    output.add(sortedCandidates[index])
                    outputList.add(ArrayList<Int>(output))
                    isSelect[index] = false
                    output.removeAt(output.size - 1)
                } else if (difference >= sortedCandidates[0]) {
                    isSelect[index] = true
                    output.add(sortedCandidates[index])
                    val outputTemp = ArrayList<Int>(output)
                    recurse(difference, index, outputList, sortedCandidates, false)
                    output = outputTemp
                    isSelect[index] = false
                    output.removeAt(output.size - 1)
                }

                index --
            }
        }

    }
}