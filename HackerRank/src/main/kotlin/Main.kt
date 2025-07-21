package org.example

import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    val line = scanner.runCatching { nextLine() }.getOrElse { "" }.trimEnd()

}