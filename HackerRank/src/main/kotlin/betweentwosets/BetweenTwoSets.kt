package org.example.betweentwosets

/**
 * See on [HackerHank](https://www.hackerrank.com/challenges/between-two-sets)
 */
object BetweenTwoSets {
    /**
     * The function bellow find all numbers that meets these conditions
     * 1. Given an array of integers, all these numbers are factors of numbers to be found (NTBF)
     * 2. Give another array of integers, all these numbers have the set of NTBF as their factors
     */
    fun mdcFrom(a: Int, b: Int): Int {
        if (b > a) mdcFrom(b, a)
        return if (b == 0) a else mdcFrom(b, a % b)
    }

    fun mmcFrom(a: Int, b: Int): Int {
        return Math.abs(a * b) / mdcFrom(a, b)
    }

    fun getTotalX(subFactors: Array<Int>, numbers: Array<Int>): Int {
        val factors = mutableSetOf<Int>()
        val mdc = numbers.reduce{ acc, num ->  mdcFrom(acc, num) }
        val mmc = subFactors.reduce{ acc, num -> mmcFrom(acc, num)  }
        
        var i = mmc
        while (i <= mdc) {
            if (mdc % i == 0) factors.add(i)
            i += mmc
        }
        println(factors)
        return factors.size
    }
}