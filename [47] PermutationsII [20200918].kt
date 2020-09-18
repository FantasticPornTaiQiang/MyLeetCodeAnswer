class PermutationsII {
    companion object{

        @JvmStatic
        fun main(args: Array<String>) {
            println(permuteUnique(intArrayOf(1,1,2)))
        }

        fun permuteUnique(nums: IntArray): List<List<Int>> {
            val isSelected = BooleanArray(nums.size)
            val numArray = nums.sortedArray()
            val outcomeList = ArrayList<List<Int>>()
            backTracking(numArray, isSelected, outcomeList)
            return outcomeList
        }

        private val outputList = ArrayList<Int>()

        fun backTracking(numArray: IntArray, isSelected: BooleanArray, outputSet:  ArrayList<List<Int>>) {
            if(outputList.size == numArray.size){
                outputSet.add(ArrayList(outputList))
                return
            }
            for(i in numArray.indices) {
                if(isSelected[i] || (i > 0 && numArray[i] == numArray[i - 1] && !isSelected[i - 1]))
                    continue
                isSelected[i] = true
                outputList.add(numArray[i])
                backTracking(numArray, isSelected, outputSet)
                isSelected[i] = false
                outputList.removeAt(outputList.lastIndex)
            }
        }

    }


}