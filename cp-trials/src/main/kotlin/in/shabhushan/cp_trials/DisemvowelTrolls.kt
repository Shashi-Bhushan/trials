package `in`.shabhushan.cp_trials

val vowels: List<Char> = listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

fun disemvowel(str: String): String {
    return str.toCharArray()
//        .partition {
//            !vowels.contains(it)
//        }.let {
//            it.first.joinToString("")
//        }
        .filter { !vowels.contains(it)}
        .joinToString("")

}
fun main() {
    println(disemvowel("This website is for losers LOL!"))
}
