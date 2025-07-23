package org.example.divisiblesumpair

/**
 * See on [HackerHank](https://www.hackerrank.com/challenges/divisible-sum-pairs)
 */
object DivisibleSumPair {

    /**
     * Naive approach O(n²)
     */
    fun naiveDivisibleSumPairs(n: Int, k: Int, ar: Array<Int>): Int {
        var count = 0

        for(i in 0 until ar.size) {
            for(j in i+1 until ar.size) {
                val division = (ar[i]+ar[j]) % k
                if( division == 0) { count ++ }
            }
        }

        return count
    }

    /**
     * Smart approach O(n)
     */
    fun divisibleSumPairs(n: Int, k: Int, ar: Array<Int>): Int {
        val modCount = IntArray(k)
        var count = 0

        ar.forEach { num ->
            val r = num % k
            val s = (k - r) % k
            count += modCount[s]
            modCount[r]++
        }

        return count
    }
}