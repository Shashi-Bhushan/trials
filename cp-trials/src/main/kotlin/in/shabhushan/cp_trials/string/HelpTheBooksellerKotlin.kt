package `in`.shabhushan.cp_trials.string

object HelpTheBooksellerKotlin

fun stockSummary(
    lstOfArt: Array<String>,
    lstOfCat: Array<String>
): String = lstOfArt.map {
    it.split(" ").let {
        it[0].substring(0, 1) to it[1].toInt()
    }
}.groupBy { it.first }.map {
    it.key to it.value.sumBy {
        it.second
    }
}.toMap().let { map ->
    lstOfCat.joinToString(" - ") {
        "($it : ${map.getOrDefault(it, 0)})"
    }
}
