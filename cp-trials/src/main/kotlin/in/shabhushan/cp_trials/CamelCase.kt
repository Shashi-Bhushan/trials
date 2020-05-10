package `in`.shabhushan.cp_trials

object CamelCase {
    fun toCamelCase(
        str: String
    ): String = if (str.isNotBlank()) {
        str.split("-", "_").mapIndexed { index, s ->
            if (index != 0) {
                s[0].toUpperCase()
            } else {
                s[0]
            } + s.drop(1)
        }.joinToString("")
    } else {
        str
    }
}
