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
import com.trulyao.calculator.ui.theme.CalculatorTheme


@Composable
fun CalculatorScreen() {
    val state by remember {
        mutableStateOf(
            CalculatorStateModel(
                currentValue = "",
                previousValue = "",
                operand = Key.None
            )
        ) }

    fun handleKeyPress(key: Key) {
        when (key.type) {
            KeyType.Number -> state.currentValue += key.value
            else -> println("Unhandled event")
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(
                "${state.previousValue} ${state.operand.value} ${state.currentValue}",
            )
        }
        Spacer(Modifier.size(10.dp))
        Keypad(handleKeyPress =  { key -> handleKeyPress(key) })
    }
}


@Preview
@Composable
fun CalculatorScreenPreview() {
    CalculatorTheme {
        CalculatorScreen()
    }
}