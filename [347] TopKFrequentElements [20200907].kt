class TopKFrequentElements {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val array = intArrayOf(1,2)
            println(topKFrequent(array, 2))
        }

        private fun topKFrequent(nums: IntArray, k: Int): IntArray {
            val array = IntArray(k)
            val map = HashMap<Int, Int>()
            for(i in nums.indices) {
                if(!map.containsKey(nums[i])) {
                    map[nums[i]] = 1
                } else {
                    val value = map[nums[i]]
                    map[nums[i]] = value!! + 1
                }
            }


            val sortedMap = map.entries.sortedBy { it.value }

            val size = sortedMap.size

            for(i in 0 until k) {
                array[i] = sortedMap[size - i - 1].key
            }
            return array
        }
    }

}