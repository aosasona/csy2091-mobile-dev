package com.trulyao.calculator

import android.content.Intent
import android.graphics.drawable.Icon
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun Header() {
    val context = LocalContext.current
    val githubIntent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/aosasona/csy2091-mobile-dev/tree/master/class-two")) }

    Box (modifier = Modifier.padding(vertical = 4.dp)) {
        TextButton(
            onClick = { context.startActivity(githubIntent) }
        ) {
            Icon(Icons.Default.FavoriteBorder, "Star on GitHub")
            Text("Star on GitHub")
        }
    }
}