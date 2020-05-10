package `in`.shabhushan.cp_trials

object OppositeStrings {
    fun vertMirror(strng: String): String = strng.split("\n").map {it.reversed()}.joinToString("\n")

    fun horMirror(strng: String): String = strng.split("\n").asReversed().joinToString("\n")

    fun rot(strng: String): String = strng.split("\n").map {it.reversed()}.asReversed().joinToString("\n")

    fun selfieAndRot(strng: String): String = strng.split("\n").map { "$it${".".repeat(it.length)}" }.let {
        val lst = it.toMutableList()

        lst.addAll(it.map{it.reversed()}.asReversed())

        lst.joinToString("\n")
    }

    fun oper(opp: (String) -> String , s: String): String = opp(s)
}
