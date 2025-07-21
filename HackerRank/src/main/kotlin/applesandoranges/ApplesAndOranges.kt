package org.example.applesandoranges

/**
 * See on [HackerHank](https://www.hackerrank.com/challenges/apple-and-orange)
 */
object ApplesAndOranges {
    fun countApplesAndOranges(
        houseStart: Int,
        houseEnd: Int,
        appleTreePos: Int,
        orangeTreePos: Int,
        apples: Array<Int>,
        oranges: Array<Int>
    ) {
        val houseRange = houseStart .. houseEnd
        val applesOnHouse = apples.count {
            (appleTreePos+it) in houseRange
        }
        val orangeOnHouse = oranges.count{
            (orangeTreePos+it) in houseRange
        }

        println(applesOnHouse)
        println(orangeOnHouse)
    }
}