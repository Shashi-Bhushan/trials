package `in`.shabhushan.cp_trials

object Xbonacci {
    /**
     * Given a seed Double array of 3 elements, find the tribonacci sequence upto n terms
     */
    fun tribonacci(
        signature: DoubleArray,
        n: Int
    ): DoubleArray = when (n > 3 && signature.size >= 3) {
        // next number in signature is sum of last three numbers
        true -> {
            val size = signature.size
            val nextElement = signature[size - 3] + signature[size - 2] + signature[size - 1]
            doubleArrayOf(
                signature[size - 3],
                *tribonacci(
                    doubleArrayOf(
                        signature[size - 2],
                        signature[size - 1],
                        nextElement
                    ), n - 1
                )
            )
        }
        false -> signature.take(n).toDoubleArray()
    }

    fun tribonacci2(
        signature: DoubleArray,
        n: Int
    ): DoubleArray {
        val sequence = generateSequence(
            Triple(signature[0], signature[1], signature[2])
        ) {
            Triple(it.second, it.third, it.first + it.second + it.third)
        }
        // Creates a Triplet sequence
        return sequence
            .map { it.first }
            .take(n)
            .toList().toDoubleArray()
    }

    /**
     * Given a seed Double array of 2 elements , find the fibonacci sequence upto n terms
     */
    fun fibonacci(
        signature: DoubleArray,
        n: Int
    ): DoubleArray = when (n > 2 && signature.size >= 2) {
        // next number in signature is sum of last two numbers
        true -> {
            val size = signature.size
            val nextElement = signature[size - 2] + signature[size - 1]
            doubleArrayOf(
                signature[size - 2],
                *fibonacci(
                    doubleArrayOf(
                        signature[size - 1],
                        nextElement
                    ), n - 1
                )
            )
        }
        false -> signature.take(n).toDoubleArray()
    }
}
