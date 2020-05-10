package `in`.shabhushan.cp_trials

object PositionAverages {
    fun posAverage(
        s: String
    ) = s.split(", ").let { list ->
        var common = 0

        (0 until list.size - 1).forEach { row ->
            (row + 1 until list.size).forEach { column ->
                common += list[row].filterIndexed { index, element ->
                    element == list[column][index]
                }.length
            }
        }

        val total = (list.size.toDouble() * (list.size.toDouble() - 1.0)) / 2.0

        common / (total * list.first().length) * 100
    }

    fun posAverage2(
        s: String
    ) = s.split(", ").let { list ->
        val total = list.first().length * (list.size.toDouble() * (list.size.toDouble() - 1.0)) / 2.0

        list.mapIndexed { index, string ->
            list.drop(index + 1).sumBy { secondString -> string.zip(secondString).count { it.first == it.second } }
        }.sum() * 100.0 / total
    }
}
