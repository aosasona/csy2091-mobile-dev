package com.trulyao.calculator

enum class Operand {
    Addition,
    Subtraction,
    Multiplication,
    Division
}

data class CalculatorStateModel(var previous: Float, var current: Float, var operand: Operand)