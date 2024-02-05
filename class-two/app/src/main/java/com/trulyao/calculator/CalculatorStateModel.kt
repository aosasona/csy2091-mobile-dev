package com.trulyao.calculator

enum class KeyType {
    Number,
    Operand,
    Special
}

enum class Key(val value: String, val type: KeyType) {
    One("1", KeyType.Number),
    Two("2", KeyType.Number),
    Three("3", KeyType.Number),
    Four("4", KeyType.Number),
    Five("5", KeyType.Number),
    Six("6", KeyType.Number),
    Seven("7", KeyType.Number),
    Eight("8", KeyType.Number),
    Nine("9", KeyType.Number),
    Zero("0", KeyType.Number),
    Dot(".", KeyType.Number),
    Plus("+", KeyType.Operand),
    Subtract("-", KeyType.Operand),
    Divide("/", KeyType.Operand),
    Multiply("x", KeyType.Operand),
    Exponent("^", KeyType.Operand),
    Equals("=", KeyType.Operand),
    Clear("CE", KeyType.Special),
    Delete("⌫", KeyType.Special),
    None("", KeyType.Operand);
}

data class CalculatorStateModel(var previousValue: String, var currentValue: String, var operand: Key)