package com.trulyao.intentz

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RoundedButton(onClick: () -> Unit, content: @Composable () -> Unit) {
    Button(onClick = onClick, shape = RoundedCornerShape(5.dp), modifier = Modifier.width(300.dp)) {
        content()
    }
}

