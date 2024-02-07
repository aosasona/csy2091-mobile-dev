package com.trulyao.calculator

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trulyao.calculator.ui.theme.CalculatorTheme


@Composable
fun CalculatorScreen() {
    var currentValue by remember { mutableStateOf("") }
    var previousValue by remember { mutableStateOf("") }
    var operand by remember { mutableStateOf(Key.None) }

    fun handleKeyPress(key: Key) {
        when (key.type) {
            KeyType.Number -> if (currentValue.length <= 9) currentValue += key.value
            else -> println("Unhandled event")
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize()) {
            Text(
                "$previousValue ${operand.value} $currentValue",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 52.sp,
                modifier = Modifier.padding(vertical = 18.dp)
            )

            Keypad(handleKeyPress = { key -> handleKeyPress(key) })
        }
    }
}


@Preview
@Composable
fun CalculatorScreenPreview() {
    CalculatorTheme {
        CalculatorScreen()
    }
}