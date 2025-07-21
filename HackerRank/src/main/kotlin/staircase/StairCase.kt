package org.example.staircase

object StairCase {
    fun staircase(n: Int) {
        val steps = "#"
        val spaces = " "

        for (i in 1..n) {
            print(spaces.repeat(n - i))
            if(i < n) println(steps.repeat(i)) else print(steps.repeat(i))
        }
    }
}