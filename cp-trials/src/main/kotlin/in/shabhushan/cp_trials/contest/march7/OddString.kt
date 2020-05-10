package `in`.shabhushan.cp_trials.contest.march7

object OddString {
  fun generateTheString2(n: Int): String = if (n % 2 == 1)
    randomString().toString().repeat(n)
  else {
    val half = n / 2

    val randomChar = randomString()

    if (half % 2 == 1)
      randomChar.toString().repeat(half) + randomString(randomChar).toString().repeat(half)
    else {
      randomChar.toString().repeat(half - 1) + randomString(exclude = randomChar).toString().repeat(half + 1)
    }
  }

  fun generateTheString(n: Int): String = "b" + "ab".substring(n % 2, 1 + n % 2).repeat(n - 1)

  private fun randomString(exclude: Char? = null) = exclude?.let {
    ('a'..'z').minus(exclude).random()
  } ?: ('a'..'z').random()

}
