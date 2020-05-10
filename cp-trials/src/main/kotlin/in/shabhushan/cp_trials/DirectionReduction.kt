package `in`.shabhushan.cp_trials

object DirectionReduction {

    /**
     * Imperative Solution
     */
    fun dirReduc(
        arr: Array<String>
    ): Array<String> {
        // iterate over each pair of entries in array
        // if pair could be reduced, reduce it and start again
        // otherwise, on reaching the end, return the final array

        val reduciblePair = mutableMapOf<String, String>()
        reduciblePair["NORTH"] = "SOUTH"
        reduciblePair["SOUTH"] = "NORTH"
        reduciblePair["EAST"] = "WEST"
        reduciblePair["WEST"] = "EAST"

        // Assume list is changed
        var changed = true
        var list = arr.toMutableList()

        while (changed) {
            var changedInThisIteration = false

            (0 until list.size - 1).forEach {
                // pair of it and it + 1
                if (!changedInThisIteration && reduciblePair[list[it]] == list[it + 1]) {
                    list = list.apply {
                        // Remove it and it + 1. Note: on removing it first will have negative consequences here.
                        removeAt(it + 1)
                        removeAt(it)
                    }

                    changedInThisIteration = true
                }
            }


            changed = changedInThisIteration
        }

        return list.toTypedArray()
    }

    private const val SEPARATOR = "-"

    /**
     * Recursive Solution
     */
    fun dirReduc2(
        arr: Array<String>
    ): Array<String> = arr.joinToString(SEPARATOR)
        .replace(Regex("NORTH${SEPARATOR}SOUTH[${SEPARATOR}]?"), "")
        .replace(Regex("SOUTH${SEPARATOR}NORTH[${SEPARATOR}]?"), "")
        .replace(Regex("WEST${SEPARATOR}EAST[${SEPARATOR}]?"), "")
        .replace(Regex("EAST${SEPARATOR}WEST[${SEPARATOR}]?"), "")
        .replace(Regex("[${SEPARATOR}]?$"), "")
        .split(SEPARATOR)
        .toTypedArray().let {
            if (it.size == arr.size)
                it
            else
                dirReduc2(it)
        }

    private fun getOppositeDirection(direction: String): String = when (direction) {
        "NORTH" -> "SOUTH"
        "SOUTH" -> "NORTH"
        "EAST" -> "WEST"
        "WEST" -> "EAST"
        else -> ""
    }

    /**
     * Functional Solution, good thing is it's in one pass
     */
    fun dirReduc3(
        arr: Array<String>
    ): Array<String> = arr.fold(listOf<String>()) { accumulator, direction ->
        if (accumulator.lastOrNull() == getOppositeDirection(direction))
            accumulator.take(accumulator.size - 1)
        else
            accumulator.plus(direction)
    }.toTypedArray()
}
