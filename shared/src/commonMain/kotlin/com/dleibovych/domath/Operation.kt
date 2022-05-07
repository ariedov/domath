package com.dleibovych.domath

sealed class Operation {

    object Addition : Operation() {
        override fun invoke(first: Int, second: Int): Int {
            return first + second
        }
    }

    object Subtraction : Operation() {
        override fun invoke(first: Int, second: Int): Int {
            return first - second
        }
    }

    object Multiplication : Operation() {

        override fun invoke(first: Int, second: Int): Int {
            return first * second
        }
    }

    object Division : Operation() {
        override fun invoke(first: Int, second: Int): Int {
            return first / second
        }
    }

    abstract operator fun invoke(first: Int, second: Int): Int

    companion object {

        val values = arrayOf(Addition, Subtraction, Multiplication, Division)
    }
}