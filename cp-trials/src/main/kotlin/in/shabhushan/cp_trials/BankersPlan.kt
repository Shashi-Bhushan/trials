package `in`.shabhushan.cp_trials

object BankersPlan {
    fun fortune(
        f0:Int, p:Double, c0:Int, n:Int, i:Double):Boolean {
        var year = 0
        var deposit = f0
        var withdrawal = c0

        val interestRate = (100.0 + p) / 100.0
        val inflationRate = (100.0 + i) / 100.0

        while (year < n-1) {
            deposit = (deposit * interestRate).toInt() - withdrawal
            withdrawal = (withdrawal * inflationRate).toInt()

            year += 1

            if (deposit < 0)
                break
        }

        return deposit >= 0
    }
}
