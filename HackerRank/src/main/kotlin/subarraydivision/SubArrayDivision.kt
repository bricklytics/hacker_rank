package org.example.subarraydivision

/**
 * See on [HackerRank](https://www.hackerrank.com/challenges/the-birthday-bar)
 */
object SubArrayDivision {

    /**
     * Naive version
     */
    fun birthday(s: Array<Int>, d: Int, m: Int): Int {
        var count = 0

        for( j in 0 .. s.size - m) {
            var birthday = 0
            repeat(m) { index ->
                birthday += s[index + j]
            }
            if (birthday == d) count++
        }
        return count
    }

    /**
     * Optimized version using prefix sum
     */
    fun birthdayOpt(s: Array<Int>, d: Int, m: Int): Int {
        val n = s.size
        val pSum = IntArray(n + 1 ) {0}

        for(i in 1..n) {
            pSum[i] = pSum[i-1] + s[i-1]
        }

        var count = 0

        for ( i in 0..n - m) {
            if(pSum[i+m] - pSum[i] == d) count++
        }
        return count
    }
}