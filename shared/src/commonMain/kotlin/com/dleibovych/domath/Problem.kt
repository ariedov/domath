package com.dleibovych.domath

data class Problem(
    val operation: Operation,
    val left: Int,
    val right: Int,

    // have to ensure the answer is always an int
    val answer: Int,
)
