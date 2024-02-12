package com.trulyao.intentz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.trulyao.intentz.ui.theme.BackgroundView
import com.trulyao.intentz.ui.theme.IntentzTheme

enum class Views {
    Home,
    BackgroundApp,
    DiceApp
}

@Composable
fun RootView() {
    val navController = rememberNavController()
    IntentzTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = Views.Home.name,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable(route = Views.Home.name) {
                        Home(navController)
                    }

                    composable(route = Views.BackgroundApp.name) {
                        BackgroundView()
                    }

                    composable(route = Views.DiceApp.name) {
                        DiceView()
                    }
                }
            }
        }
    }
}

@Composable
fun Home(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Text("Select task to load", fontSize = 20.sp, fontWeight = FontWeight(weight = 600))

        Spacer(modifier = Modifier.height(18.dp))

        RoundedButton(onClick = { navController.navigate(Views.BackgroundApp.name) }) {
            Text("Background change")
        }

        RoundedButton(onClick = { navController.navigate(Views.DiceApp.name) }) {
            Text("Dice roll")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RootView()
}
