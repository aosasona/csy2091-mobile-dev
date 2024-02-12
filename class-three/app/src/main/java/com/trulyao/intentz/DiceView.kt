package com.trulyao.intentz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.trulyao.intentz.ui.theme.IntentzTheme

// Convert an integer to a matching drawable ID
fun intToID(value: Int): Int {
    return when (value) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> {
            println("Received $value, unexpected!")
            return 1
        }
    }
}

@Composable
fun DiceView() {
    val ctx = LocalContext.current
    var diceOne by remember { mutableStateOf(1) }
    var diceTwo by remember { mutableStateOf(1) }

    fun generateRandomInt(): Int {
        return (1..6).random()
    }

    fun roll() {
        diceOne = generateRandomInt()
        diceTwo = generateRandomInt()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(if (diceOne == diceTwo) "Both results are the same!" else "Oof, got different results.")

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = intToID(diceOne)),
                contentDescription = "First dice roll result",
                modifier = Modifier.size(120.dp)
            )

            Image(
                painter = painterResource(id = intToID(diceTwo)),
                contentDescription = "Second dice roll result",
                modifier = Modifier.size(120.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        RoundedButton(onClick = { roll() }) {
            Text(text = "Roll")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BackgroundViewPreview() {
    IntentzTheme {
        DiceView()
    }
}
