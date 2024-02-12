package com.trulyao.intentz

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

// The purpose of this task is to demonstrate using Intents
class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "App is in the onCreate phase")

        setContent {
            RootView()
        }
    }

    override fun onStart() {
        Log.d(TAG, "App is in the onStart phase")
        super.onStart()
    }

    override fun onPause() {
        Log.d(TAG, "App is in the onPause phase")
        super.onPause()
    }

    override fun onResume() {
        Log.d(TAG, "App is in the onResume phase")
        super.onResume()
    }

    override fun onStop() {
        Log.d(TAG, "App is in the onStop phase")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "App is in the onDestroy phase")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.d(TAG, "App is in the onRestart phase")
        super.onRestart()
    }
}