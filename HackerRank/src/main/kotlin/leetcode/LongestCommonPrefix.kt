package org.example.longestcommonsbstr

/**
 * See on [Leetcode](https://leetcode.com/problems/longest-common-prefix/)
 */
object LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        var commonPrefix = ""
        val base = strs[0]

        val maxSubtr = mutableListOf<String>()
        strs.forEach { str ->
            var j = 0
            var pMax = ""
            while (j < base.length) {
                val s2 =
                    if (base.length > 1) base.substring(0, ++j)
                    else { j++; base }

                if(s2.isEmpty()) break
                if (str.startsWith(s2)) {
                    pMax = s2
                }
            }
            maxSubtr.add(pMax)
        }

        commonPrefix = maxSubtr.reduceOrNull { acc, s ->
            if (acc.length > s.length) s else acc
        } ?: ""

        return commonPrefix
    }
}

/**
 * See on [LeetCode](https://leetcode.com/problems/roman-to-integer/)
 */
object RomanIntegers {
    fun romanToInt(s: String): Int {
        val romanTable = mapOf(
            'M' to 1000,
            'D' to 500,
            'C' to 100,
            'L' to 50,
            'X' to 10,
            'V' to 5,
            'I' to 1
        )

        val composedRoman = mapOf(
            "CM" to 100,
            "CD" to 100,
            "XC" to 10,
            "XL" to 10,
            "IX" to 1,
            "IV" to 1
        )

        var value = s.sumOf { romanTable[it] ?: 0 }
        var i = 0
        while(i < s.length - 1 ) {
            val duo = s.substring(i, i+2)
            value -= 2*(composedRoman[duo] ?: 0)
            i++
        }

        return value
    }
}