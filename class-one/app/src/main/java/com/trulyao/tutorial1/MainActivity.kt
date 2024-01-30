package com.trulyao.tutorial1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    enum class AlertType {
        Success,
        Failure
    }
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val credentials = HashMap<String, String>()
        credentials["john"] = "doedman"
        credentials["randy"] = "Morton12"
        credentials["ben_9"] = "TennysonG"

        val signInButton = findViewById<Button>(R.id.signInBtn)
        val usernameField = findViewById<EditText>(R.id.username)
        val passwordField = findViewById<EditText>(R.id.password)

        signInButton.setOnClickListener {
            if (usernameField.text.isEmpty()) {
                alert("Username cannot be empty", AlertType.Failure)
                return@setOnClickListener
            }

            if (passwordField.text.isEmpty()) {
                alert("Password cannot be empty", AlertType.Failure)
                return@setOnClickListener
            }

            val username = usernameField.text.toString().lowercase()
            if (!credentials.containsKey(username)) {
                alert("No account with this username exists!", AlertType.Failure)
                return@setOnClickListener
            }

            if (credentials[username] != passwordField.text.toString()) {
                alert("Invalid password provided for user $username", AlertType.Failure)
                return@setOnClickListener
            }

            alert("Welcome back, $username!", AlertType.Success)
        }
    }

    private fun alert(message: String, alertType: AlertType) {
        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setTitle(when (alertType) {
            AlertType.Failure -> "Error"
            AlertType.Success -> "Success"
        })
        alertBuilder.setMessage(message)
        alertBuilder.setNegativeButton("Dismiss") { dialog, _ -> dialog.dismiss() }

        val alertDialog: AlertDialog = alertBuilder.create()
        alertDialog.setCancelable(true)
        alertDialog.show()
    }
}