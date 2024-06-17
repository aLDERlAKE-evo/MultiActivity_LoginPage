package com.example.multiple_activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var usernameText: EditText
    private lateinit var passwordText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize the EditText fields after setting the content view
        usernameText = findViewById(R.id.usernameField)
        passwordText = findViewById(R.id.passwordField)
    }

    fun clickLogin(view: View) {
        Log.i("Login Activity", "Login button clicked")

        // Retrieve the latest values of username and password from EditText views
        val username: String = usernameText.text.toString()
        val password: String = passwordText.text.toString()

        val lintent = Intent(this, User_Data::class.java)
        lintent.putExtra("UNAME", username)
        lintent.putExtra("PASSWORD", password)
        startActivity(lintent)
    }
}
