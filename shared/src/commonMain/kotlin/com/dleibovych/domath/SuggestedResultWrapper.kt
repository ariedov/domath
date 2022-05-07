package com.dleibovych.domath

class SuggestedResultWrapper {

    private var resultString = StringBuilder()

    val result: String
        get() = resultString.toString()

    fun clear(): String {
        resultString = StringBuilder()
        return result
    }

    fun submitDigit(digit: String): String {
        resultString.append(digit)
        return result
    }

    fun submitNegative(): String {
        if (resultString.isNotEmpty()) return result

        resultString.append("-")
        return result
    }

    fun backspace(): String {
        if (resultString.isEmpty()) return result

        resultString.deleteAt(resultString.length - 1)
        return result
    }
}