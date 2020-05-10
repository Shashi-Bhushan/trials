package `in`.shabhushan.cp_trials

import kotlin.math.abs

object ProdSum {
    fun prod2Sum(a:Long, b:Long, c:Long, d:Long):List<LongArray> = mutableListOf<LongArray>().apply {
        val ad = a * d
        val bc = b * c
        val ac = a * c
        val bd = b * d

        val firstArray = longArrayOf(ac + bd, abs(bc - ad)).sortedArray()
        val secondArray = longArrayOf(ad + bc, abs(bd - ac)).sortedArray()

        this.add(firstArray)

        if(firstArray[0] != secondArray[0] && firstArray[1] != secondArray[1]) {
            this.add(secondArray)
        }
    }.sortedBy {
        it.first()
    }.apply {
        println("Arrya is ${this[0]}")
    }

    fun prod2Sum2(a:Long, b:Long, c:Long, d:Long):List<LongArray> = mutableListOf<LongArray>().apply {
        val ad = a * d
        val bc = b * c
        val ac = a * c
        val bd = b * d

        add(longArrayOf(ac + bd, abs(bc - ad)).sortedArray())
        add(longArrayOf(ad + bc, abs(bd - ac)).sortedArray())
    }.sortedBy {
        it.first()
    }.distinctBy {
        it.first()
    }
}
