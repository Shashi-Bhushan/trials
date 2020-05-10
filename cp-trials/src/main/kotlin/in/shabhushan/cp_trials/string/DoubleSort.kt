package `in`.shabhushan.cp_trials.string

object DoubleSort {
    fun dbSort(a:Array<Any>):Array<Any> = a.partition {
        it !is String
    }.let {
        val arr: List<Int> = it.first as List<Int>
        val secondArr: List<String> = it.second as List<String>
        (arr.sorted() + secondArr.sorted()).toTypedArray()
    }
}
