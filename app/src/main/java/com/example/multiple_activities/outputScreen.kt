package com.example.multiple_activities

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class outputScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_output_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val usernameData = intent.getStringExtra("USERNAME")
        val passwordData = intent.getStringExtra("PASSWORD")
        val genderData = intent.getStringExtra("GENDER")
        val ageData = intent.getStringExtra("AGE")
        val hobbiesData = intent.getStringArrayListExtra("HOBBIES")

        val username: TextView = findViewById(R.id.unameView)
        val password: TextView = findViewById(R.id.passView)
        val gender: TextView = findViewById(R.id.genderView)
        val age: TextView = findViewById(R.id.ageView)
        val hobbies: TextView = findViewById(R.id.hobbiesView)

        username.text = "Username: $usernameData"
        password.text = "Password: $passwordData"
        gender.text = "Gender: $genderData"
        age.text = "Age: $ageData"

        hobbies.text = "Hobbies: ${hobbiesData?.joinToString(", ")}"
    }
}
