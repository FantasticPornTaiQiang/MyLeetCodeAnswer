class PermutationSequence {
    companion object {

        var output = ""

        var nums = ArrayList<Int>()

        @JvmStatic
        fun main(args: Array<String>) {
            println(getPermutation(4, 9))
        }

        private fun getPermutation(n: Int, k: Int): String {
            for(i in 1..n)
                nums.add(i)
            getPermutationBit(n, k)
            return output
        }

        private fun getPermutationBit(n: Int, k: Int) {
            if(n <= 0) return
            val removeWhatIndex = (1 + (k - 1) / factorial(n - 1)) - 1
            val removeWhat = nums[removeWhatIndex]
            output += removeWhat
            nums.removeAt(removeWhatIndex)
            getPermutationBit(n - 1, k - (removeWhatIndex) * factorial(n - 1))
        }

        private fun factorial(n: Int): Int = when {
            n < 0 -> throw UnsupportedOperationException("n<1 can't be reduced.")
            n == 0 -> 1
            else -> (1..n).reduce { acc, i -> acc * i }
        }
    }
}