package com.dleibovych.domath.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dleibovych.domath.MathProblemsGenerator
import com.dleibovych.domath.PracticeTracker
import com.dleibovych.domath.Problem
import com.dleibovych.domath.SuggestedResultWrapper
import kotlin.random.Random

class MainViewModel : ViewModel() {

    private val _nextProblem = MutableLiveData<Problem>()
    val nextProblem: LiveData<Problem> = _nextProblem

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    private val _total = MutableLiveData<String>()
    val total: LiveData<String> = _total

    private val problemGenerator = MathProblemsGenerator(Random(System.currentTimeMillis()))
    private val resultWrapper = SuggestedResultWrapper()
    private val practiceTracker = PracticeTracker()

    fun practice() {
        _result.value = resultWrapper.clear()
        practiceTracker.clear()

        _nextProblem.value = problemGenerator.generateMathProblem()
        _total.value = "${practiceTracker.correct} / ${practiceTracker.total}"
    }

    fun submitDigit(digit: String) {
        _result.value = resultWrapper.submitDigit(digit)
    }

    fun submitNegative() {
        _result.value = resultWrapper.submitNegative()
    }

    fun backspace() {
        _result.value = resultWrapper.backspace()
    }

    fun submitResult() {
        val problem = nextProblem.value ?: return
        val result = resultWrapper.result

        practiceTracker.submitResult(problem, result)

        _result.value = resultWrapper.clear()
        _nextProblem.value = problemGenerator.generateMathProblem()
        _total.value = "${practiceTracker.correct} / ${practiceTracker.total}"
    }
}