package com.trulyao.calculator

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
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
            KeyType.Number ->  {
                if (currentValue.length >= 9) return;
                if (key.value ==  "." && currentValue.contains(".")) return;
                currentValue += key.value
            }
            KeyType.Special -> when (key) {
                Key.Delete -> {
                    if (currentValue.isEmpty()) return;
                    currentValue = currentValue.slice(0..currentValue.length - 2)
                }

                Key.Clear -> {
                    currentValue = "";
                    previousValue = "";
                    operand = Key.None;
                }
                else -> print("Unhandled special key")
            }
            else -> println("Unhandled event")
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp)
                .padding(horizontal = 12.dp)
        ) {
            Box(modifier = Modifier) {
                Header()

                Text(
                    if (currentValue.isNotEmpty()) currentValue else previousValue,
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 52.sp,
                )
            }

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