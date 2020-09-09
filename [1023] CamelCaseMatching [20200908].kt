
class CamelCaseMatching {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            camelMatchSolution("ControlPanel", "CooP")
        }

        fun camelMatch(queries: Array<String>, pattern: String): BooleanArray {
            val answerArray = BooleanArray(queries.size)
            for(i in queries.indices) {
                answerArray[i] = camelMatchSolution(queries[i], pattern)
            }
            return answerArray
        }

        private fun camelMatchSolution(query: String, pattern: String): Boolean{
            //val patternList = splitPattern(pattern)
            var queryString = query
            var regexString = "[a-z]*"
            for(i in pattern.indices) {
//                val queryStringLast = queryString.replaceFirst(pattern[i].toString(), "")
//                if(queryStringLast.length == queryString.length) return false
//                queryString = queryStringLast
                regexString += pattern[i] + "[a-z]*"
            }
            val regex = regexString.toRegex()
            return query.matches(regex)
        }


        //题目描述不清
        private fun splitPattern(pattern: String): List<String> {
            val patternList = ArrayList<String>()
            var patternString = pattern[0].toString()
            for(i in 1 until pattern.length - 1) {
                if(pattern[i] in 'A'..'Z') {
                    patternList.add(patternString)
                    patternString = pattern[i].toString()
                } else {
                    patternString += pattern[i].toString()
                }
            }

            if(pattern.last() in 'A'..'Z') {
                patternList.add(patternString)
                if(pattern.length > 1)
                    patternList.add(pattern.last().toString())
            } else {
                patternList.add(patternString + pattern.last())
            }
            return patternList
        }

    }

}