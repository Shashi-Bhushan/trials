package `in`.shabhushan.cp_trials.math.logic

object IncrementalString {
    val incrementMap = mapOf(
        '0' to '1',
        '1' to '2',
        '2' to '3',
        '3' to '4',
        '4' to '5',
        '5' to '6',
        '6' to '7',
        '7' to '8',
        '8' to '9',
        '9' to '0'
    )

    fun incrementString(str: String): String =
        // if String is not blank and last number is a digit
        if (str.isNotBlank() && str.last() in '0'..'9') {
            // if last number is a digit
            if (str.last() == '9') {
                var index = str.length - 1

                // Find all the digits '9' at the end
                while (0 <= index && str[index] == '9') {
                    index -= 1
                }

                // if index is -1, in case of string with all characters '9' (say 999)
                if (index == -1) {
                    "1" + "0".repeat(str.length)
                }
                // if the preceding character to 9 is a digit(say 79), increment the digit
                else if (str[index] in '0'..'9') {
                    str.substring(0 until index) + incrementMap[str[index]]
                } else {
                    // it means all digits are 9, add a one at the end (no need to look in map)
                    str.substring(0..index) + "1"
                } + ("0".repeat(str.length - index - 1)) // add relevant number of zeros at the end
            } else {
                // last number is not '9', simply increment it
                str.substring(0 until str.length - 1) + incrementMap[str.last()]
            }
        } else {
            "$str${1}"
        }

    fun incrementString2(str: String) : String = str.takeLastWhile { it.isDigit() }.let { digitString ->
        str.dropLast(digitString.length) +
                ((digitString.toIntOrNull() ?: 0) + 1).toString().padStart(digitString.length, '0')
    }
}
