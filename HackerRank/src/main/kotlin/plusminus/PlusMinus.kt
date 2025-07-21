package org.example.plusminus

import java.math.RoundingMode

object PlusMinus {
    fun plusMinus(array: Array<Int>)    {
        var positives = 0
        var negatives = 0
        var zeroes = 0

        array.forEach { item ->
            when {
                item > 0 -> positives++
                item < 0 -> negatives++
                else -> zeroes++
            }
        }
        println(positives.toBigDecimal().divide(array.size.toBigDecimal(),6, RoundingMode.HALF_EVEN))
        println(negatives.toBigDecimal().divide(array.size.toBigDecimal(),6, RoundingMode.HALF_EVEN))
        println(zeroes.toBigDecimal().divide(array.size.toBigDecimal(),6, RoundingMode.HALF_EVEN))
    }
}