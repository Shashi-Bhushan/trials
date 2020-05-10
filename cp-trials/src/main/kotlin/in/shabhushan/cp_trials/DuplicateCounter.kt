package `in`.shabhushan.cp_trials

object DuplicateCounter {
    fun duplicateCount(text: String): Int {
        val frequency = mutableMapOf<Char, Int>()

        text.toCharArray().map { it.toLowerCase() }
            .forEach { if (frequency.containsKey(it)) frequency[it] = frequency[it]!!.plus(1) else frequency[it] = 1 }

        return frequency.filter { it.value > 1 }.size
    }

    fun duplicateCount2(text: String) = text.groupBy { it.toLowerCase() }.filter { it.value.size > 1 }.size

    fun main() {
        val text = "dA" + "c".repeat(10) + "b".repeat(100) + "a".repeat(1000)

        println(duplicateCount2(text))

        println(duplicateCount2("abcdeA"))
    }
}
