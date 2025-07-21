package org.example.camelcase

object CamelCase {
    fun camelCase(str: String): Int {
        val regex = Regex("(?<=[a-z])(?=[A-Z])")
        val words = str.split(regex).toList()

        return words.size
    }
}