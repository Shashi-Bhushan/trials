package `in`.shabhushan.cp_trials

object Squares {
    fun sqInRect(
        lng: Int,
        wdth: Int
    ): List<Int>? = if (lng == 1 && wdth == 1) listOf(1) else if (lng == wdth) null else {
        if (lng < wdth)
            mutableListOf(lng).apply {
                sqInRect(lng, wdth - lng)?.let{ this.addAll(it) }

                if (lng != 1 && lng == wdth - lng) this.add(lng)
            }.toList()
        else
            mutableListOf(wdth).apply {
                sqInRect(lng - wdth, wdth)?.let { this.addAll(it) }
                if (wdth != 1 && lng - wdth == wdth) this.add(wdth)
            }.toList()
    }

    fun sqInRect2(
        l: Int,
        w: Int,
        list: List<Int> = listOf<Int>()
    ): List<Int>? = if (l == w && list.isEmpty()) null else if (l == w) list.plus(l) else {
        val min = minOf(l, w)

        sqInRect2(maxOf(l, w) - min, min, list.plus(min))
    }
}
