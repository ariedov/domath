package com.dleibovych.domath

class PracticeTracker {

    var correct: Int = 0
        private set

    var incorrect: Int = 0
        private set

    val total: Int
        get() = correct + incorrect

    fun submitResult(problem: Problem, result: String) {
        val isCorrect = problem.answer == result.toInt()
        if (isCorrect) {
            correct += 1
        } else {
            incorrect += 1
        }
    }

    fun clear() {
        correct = 0
        incorrect = 0
    }
}