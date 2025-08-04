package org.example.magicsquare

/**
 * See on [HackerRank](https://www.hackerrank.com/challenges/magic-square-forming)
 */
object MagicSquare {

    /**
     * For a magic square 3 x 3 there are only 8 possible combinations where
     * we can find the magic number M by summing the numbers on each row, column
     * and diagonals, such as M = (n³+n)/2
     */
    fun formingMagicSquare(s: Array<Array<Int>>): Int {
        val magicSquares = listOf(
            arrayOf(intArrayOf(8,1,6), intArrayOf(3,5,7), intArrayOf(4,9,2)),
            arrayOf(intArrayOf(6,1,8), intArrayOf(7,5,3), intArrayOf(2,9,4)),
            arrayOf(intArrayOf(4,9,2), intArrayOf(3,5,7), intArrayOf(8,1,6)),
            arrayOf(intArrayOf(2,9,4), intArrayOf(7,5,3), intArrayOf(6,1,8)),
            arrayOf(intArrayOf(8,3,4), intArrayOf(1,5,9), intArrayOf(6,7,2)),
            arrayOf(intArrayOf(4,3,8), intArrayOf(9,5,1), intArrayOf(2,7,6)),
            arrayOf(intArrayOf(6,7,2), intArrayOf(1,5,9), intArrayOf(8,3,4)),
            arrayOf(intArrayOf(2,7,6), intArrayOf(9,5,1), intArrayOf(4,3,8))
        )

        /**
         * Since only eight possible squares we can find, the easiest way of find
         * the lower cost is compare to each one with the input matrix and compute the
         * minimal cost change
         */
        val costToConvert: (Array<Array<Int>>, Array<IntArray>)-> Int = { origin, target ->
            var cost = 0
            for (i in 0..2) {
                for (j in 0..2) {
                    cost += kotlin.math.abs(origin[i][j] - target[i][j])
                }
            }
            cost
        }

        return magicSquares.minOf { costToConvert(s, it) }
    }
}