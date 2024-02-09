package com.trulyao.calculator

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val buttons = listOf(
    listOf(Key.Clear, Key.Exponent, Key.Delete, Key.Plus),
    listOf(Key.Nine, Key.Eight, Key.Seven, Key.Subtract),
    listOf(Key.Six, Key.Five, Key.Four, Key.Multiply),
    listOf(Key.Three, Key.Two, Key.One, Key.Divide),
    listOf(Key.Zero, Key.Dot,  Key.Equals),
);

@Composable
fun Keypad(handleKeyPress: (Key) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
//            .padding(horizontal = 10.dp)
//            .padding(bottom = 18.dp)
    ) {
        buttons.forEach { members ->
            Row(modifier = Modifier.fillMaxWidth()) {
                members.forEach { button ->
                    Button(
                        onClick = { handleKeyPress(button) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (button.type != KeyType.Number) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.secondary
                            },

                            contentColor = if (button.type != KeyType.Number) {
                                MaterialTheme.colorScheme.secondary
                            } else {
                                MaterialTheme.colorScheme.primary
                            }
                        ),
                        modifier = Modifier
                            .height(95.dp)
                            .clip(CircleShape)
                            .padding(6.dp)
                            .weight(if (button == Key.Equals) 0.5f else 0.25f)
                    ) {
                        Text(
                            button.value,
                            fontSize = if (button.type != KeyType.Number) 22.sp else 20.sp
                        )
                    }
                }
            }
        }
    }

}