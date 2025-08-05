package org.example.superreducedstring

/**
 * See [HackerRank](https://www.hackerrank.com/challenges/reduced-string)
 */
object SuperReducedString {

    fun superReducedString(s: String): String {
        val stack = ArrayDeque<Char>()

        s.forEach { char ->
            if (stack.isNotEmpty() && stack.last() == char) {
                stack.removeLast()
            } else {
                stack.addLast(char)
            }
        }

        return if (stack.isEmpty()) "Empty String" else stack.joinToString("")
    }
}