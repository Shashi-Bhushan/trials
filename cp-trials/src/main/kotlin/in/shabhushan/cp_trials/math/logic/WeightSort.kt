package `in`.shabhushan.cp_trials.math.logic

object WeightSort {
    fun orderWeight(string:String):String = string.split(" ").let {
        it.sortedWith(compareBy({
            it.map { Integer.valueOf(it.toString()) }.sum()
        },{
            it
        })).joinToString(" ")
    }
}
