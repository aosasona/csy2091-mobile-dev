package com.trulyao.intentz.ui.theme

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.trulyao.intentz.RoundedButton

@Composable
fun BackgroundView() {
    val ctx = LocalContext.current
    var parsedBackgroundColor by remember { mutableStateOf("151515") }
    var bgColor by remember {
        mutableStateOf("")
    }

    fun changeBgColor() {
        if (!bgColor.matches(Regex("^[a-zA-Z0-9]{6}$"))) {
            Toast.makeText(ctx, "Invalid HEX code provided, e.g. 10FAB2", Toast.LENGTH_SHORT)
                .show()
            return;
        }

        parsedBackgroundColor = bgColor
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.fromHex(parsedBackgroundColor))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            TextField(
                value = bgColor,
                onValueChange = { bgColor = it },
                placeholder = { Text("e.g. FAFAFA") },
                label = { Text("Hex code") },
                modifier = Modifier.width(300.dp)
            )

            Spacer(modifier = Modifier.height(6.dp))

            RoundedButton(
                onClick = { changeBgColor() },
            ) {
                Text("Change BG Color")
            }
        }
    }
}

fun Color.Companion.fromHex(hexCode: String) = Color(android.graphics.Color.parseColor("#$hexCode"))

@Preview(showBackground = true)
@Composable
fun BackgroundViewPreview() {
    IntentzTheme {
        BackgroundView()
    }
}