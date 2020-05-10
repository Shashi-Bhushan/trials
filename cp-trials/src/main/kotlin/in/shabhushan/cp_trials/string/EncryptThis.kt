package `in`.shabhushan.cp_trials.string

import java.util.regex.Pattern
import java.util.stream.Collectors

object EncryptThis {
    fun encryptThis(text:String): String = text.split(" ").joinToString(" ") {h ->
        h[0].toInt().toString() + when{
            h.length == 2 -> h.last()
            h.length > 2 -> h.last() + h.substring(2 until h.length-1) + h[1]
            else -> ""
        }
    }

    val pattern = Pattern.compile(" +")

    fun encryptThis2(text: String): String = pattern.splitAsStream(text).map(mapper).collect(Collectors.joining(" "))

    private val mapper = { word: String ->
        val builder = StringBuilder().append(word[0].toInt())
        when (word.length) {
            1    -> {}
            2    -> builder.append(word[1])
            else -> builder.append(word[word.length - 1]).append(word.subSequence(2, word.length - 1)).append(word[1])
        }
        builder.toString()
    }
}
