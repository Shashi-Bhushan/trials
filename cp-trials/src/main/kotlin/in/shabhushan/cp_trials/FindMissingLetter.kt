package `in`.shabhushan.cp_trials

object FindMissingLetter {
    val capitalMap = mapOf(
        'A' to 1,
        'B' to 2,
        'C' to 3,
        'D' to 4,
        'E' to 5,
        'F' to 6,
        'G' to 7,
        'H' to 8,
        'I' to 9,
        'J' to 10,
        'K' to 11,
        'L' to 12,
        'M' to 13,
        'N' to 14,
        'O' to 15,
        'P' to 16,
        'Q' to 17,
        'R' to 18,
        'S' to 19,
        'T' to 20,
        'U' to 21,
        'V' to 22,
        'W' to 23,
        'X' to 24,
        'Y' to 25,
        'Z' to 26
    )

    val smallMap = mapOf(
        'a' to 1,
        'b' to 2,
        'c' to 3,
        'd' to 4,
        'e' to 5,
        'f' to 6,
        'g' to 7,
        'h' to 8,
        'i' to 9,
        'j' to 10,
        'k' to 11,
        'l' to 12,
        'm' to 13,
        'n' to 14,
        'o' to 15,
        'p' to 16,
        'q' to 17,
        'r' to 18,
        's' to 19,
        't' to 20,
        'u' to 21,
        'v' to 22,
        'w' to 23,
        'x' to 24,
        'y' to 25,
        'z' to 26
    )

    fun findMissingLetter(array: CharArray): Char {
        val map = if (array[0] in 'A'..'Z')
            capitalMap
        else
            smallMap

        val i = (map[array[0]]!!..map[array[array.size - 1]]!!).sum() - array.sumBy { map[it]!! }

        return map.filter {
            it.value == i
        }.keys.first()
    }

    fun findMissingLetter2(array: CharArray): Char = (array.first()..array.last()).first { it !in array }
}
