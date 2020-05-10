fun countPositivesSumNegatives(input: Array<Int>): Array<Int> = input.partition {
    it < 0
}.let {
    arrayOf(it.second.count(), it.first.sum())
}