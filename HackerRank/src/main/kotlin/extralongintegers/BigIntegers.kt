package org.example.extralongintegers

object BigIntegers {
    fun stringProduct(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") return "0"

        val len1 = num1.length
        val len2 = num2.length
        val result = IntArray(len1 + len2)

        // Multiply each digit and add to the correct position
        for (i in len1 - 1 downTo 0) {
            for (j in len2 - 1 downTo 0) {
                val product = num1[i].digitToInt() * num2[j].digitToInt()
                val pos1 = i + j        //carry out position
                val pos2 = i + j + 1    //current digit position
                val total = product + result[pos2]

                result[pos2] = total % 10
                result[pos1] += total / 10
            }
        }

        // Convert result array to string, removing leading zeros
        val sb = StringBuilder()
        for (digit in result) {
            if (!(sb.isEmpty() && digit == 0)) { // Skip leading zeros
                sb.append(digit)
            }
        }

        return if (sb.isEmpty()) "0" else sb.toString()
    }

    fun extraLongFactorials(n: Int) {
        var result = "1"
        for (i in 2..n) {
            result = stringProduct(result, i.toString())
        }
        println(result)
    }
}