class FirstMissingPositive {

    companion object{

        @JvmStatic
        fun main(args: Array<String>) {
            println(firstMissingPositive(intArrayOf(1,2,0)))
        }

        fun firstMissingPositive(nums: IntArray): Int {

            for(i in nums.indices) {
                while(nums[nums[i] - 1] != nums[i] && nums[i] > 0 && nums[i] <= nums.size)
                nums[i] = nums[nums[i] - 1].also { nums[nums[i] - 1] = nums[i] }
            }

            for(i in nums.indices) {
                if(nums[i] - 1 != i)
                    return i + 1
            }

            return nums.size + 1
        }
    }
}