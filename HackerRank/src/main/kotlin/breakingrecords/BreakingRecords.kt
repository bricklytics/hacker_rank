package org.example.breakingrecords

object BreakingRecords {

    fun breakingRecords(scores: Array<Int>): Array<Int> {
        val records = mutableListOf<Int>()
        var min = scores[0]
        var max = scores[0]
        var countMin = 0
        var countMax = 0

        for (i in 1..scores.lastIndex) {
            if(min > scores[i]) {countMin++; min = scores[i] }
            if(max < scores[i]) {countMax++; max = scores[i] }
        }
        records.add(0, countMax)
        records.add(1, countMin)

        return records.toTypedArray()
    }
}