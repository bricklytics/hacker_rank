package org.example.countingsort

object CountingSort {
    fun countingSort(arr: Array<Array<String>>) {
        val counting: Array<Int> = Array(arr.size + 1) { 0 }
        val sortedArr = Array(arr.size) { "" }
        val tempArr: Array<Pair<Int, String>> = Array(arr.size) {
            if (it < arr.size / 2) arr[it][0].toInt() to "-"
            else arr[it][0].toInt() to arr[it][1]
        }

        for (i in 1 ..< tempArr.size) { counting[tempArr[i].first]++ }
        for (i in 1..tempArr.size) { counting[i] += counting[i-1] }

        tempArr.reversed().map {
            sortedArr[counting[it.first]--] = it.second
        }

        print(sortedArr.joinToString(" "))
    }

    fun countingSort2(arr: Array<Array<String>>) {
        val n = arr.size
        val half = n / 2

        val processedArr = arr.mapIndexed { index, (key, value) ->
            Pair(key.toInt(), if (index < half) "-" else value)
        }
        val maxKey = processedArr.maxOf { it.first }
        val count = IntArray(maxKey + 1)
        val output = Array(n) { Pair(0, "") }

        for ((key, _) in processedArr) {
            count[key]++
        }

        for (i in 1..maxKey) {
            count[i] += count[i - 1]
        }

        for (i in processedArr.indices.reversed()) {
            val (key, value) = processedArr[i]
            count[key]--
            output[count[key]] = Pair(key, value)
        }

        print(output.joinToString(" ") { it.second })
    }
}