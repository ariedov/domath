package com.dleibovych.domath

import kotlin.random.Random

class MathProblemsGenerator(
    private val random: Random
) {

    fun generateMathProblem(): Problem {
        return when (val operation = Operation.values[random.nextInt(OPERATIONS)]) {
            Operation.Division -> generateForDivision()
            Operation.Multiplication -> generateForMultiplication()
            else -> {
                val first = (0..50).random()
                val second = (0..50).random()
                val result = operation(first, second)

                return Problem(
                    operation, first, second, result
                )
            }
        }
    }

    private fun generateForMultiplication(): Problem {
        val first = (0..50).random()
        val second = (0..10).random()
        val result = Operation.Multiplication(first, second)
        return Problem(
            Operation.Multiplication, first, second, result
        )
    }

    private fun generateForDivision(): Problem {
        val denominator = 1 + random.nextInt(9)
        val result = random.nextInt(10)
        val numerator = result * denominator
        return Problem(
            Operation.Division,
            numerator,
            denominator,
            result
        )
    }

    companion object {
        const val OPERATIONS = 4
    }
}