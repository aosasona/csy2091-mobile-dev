package com.trulyao.calculator.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DefaultColorScheme = darkColorScheme(
    primary = Indigo600,
    secondary = Indigo200,
    surface = Dark
)

@Composable
fun CalculatorTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DefaultColorScheme,
        typography = Typography,
        content = content
    )
}