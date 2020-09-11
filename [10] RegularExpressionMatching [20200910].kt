class RegularExpressionMatching {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(isMatch("bbbba", ".*a*a"))
        }

        fun isMatch(s: String, p: String): Boolean {

            val patternList = splitPattern(p)

            var index = 0
            var whatLetter = ' '
            var isStar = false

            var patternIndex = 0
            while (patternIndex <= patternList.size - 1) {
                val pattern = patternList[patternIndex]
                when (pattern.length) {
                    1 -> {
                        if(isStar && index >= s.length && whatLetter == s[index - 1]) {
                            index --
                            isStar = false
                        }
                        if(index >= s.length)
                            return false
                        if(pattern != ".") {
                            if(s[index].toString() != pattern) {
                                return false
                            }
                        }
                        index ++
                    }
                    2 -> {
                        if(pattern == ".*") {
                            if(patternIndex == patternList.size - 1) return true
                            else {
//                                patternIndex ++
//
//                                var nowIndex = index
//                                var continualLetter = false
//                                while(patternIndex <= patternList.size - 1 && patternList[patternIndex] != ".*") {
//                                    if(patternIndex <= patternList.size - 2 && patternList[patternIndex + 1].length == 1) {
//
//                                    }
//                                    val findIndex = s.indexOf(patternList[patternIndex], nowIndex)
//                                    if(nowIndex > findIndex) return false
//                                    else nowIndex = findIndex
//                                    nowIndex ++
//                                }
                            }
                        }
                        else{
                            while(index < s.length && s[index] == pattern[0]) {
                                whatLetter = s[index]
                                isStar = true
                                index ++
                            }
                        }
                    }
                }
                patternIndex ++
            }

            if(index >= s.length) return true
            return false
        }

        private fun splitPattern(p: String): List<String> {
            val patternList = ArrayList<String>()

            if (p.length <= 1) {
                patternList.add(p)
                return patternList
            }

            var index = 0
            var isStar = true
//            var whatStar = ' '
            while(index < p.length - 1) {
                if(isStar && (p[index] == '*' /*|| p[index] == whatStar*/)) {
                    index++
                    continue
                } else if(p[index + 1] == '*') {
                    val pattern = p[index].toString() + p[index + 1]
                    patternList.add(pattern)
                    //whatStar = p[index]
                    index += 2
                    isStar = true
                } else {
                    patternList.add(p[index ++].toString())
                    isStar = false
                }
            }
            if(index == p.length - 1 && p[index] != '*' /*&& p[index] != whatStar*/) patternList.add(p[index].toString())

            return patternList
        }
    }
}