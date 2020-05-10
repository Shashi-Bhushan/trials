package `in`.shabhushan.cp_trials.tricks

/**
 * Solution for Kotlin Tricks#1
 */
operator fun<T: Any> String.invoke(s: T): T = s
