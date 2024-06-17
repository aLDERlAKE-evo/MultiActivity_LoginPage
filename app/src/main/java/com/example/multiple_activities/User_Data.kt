package com.example.multiple_activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class User_Data : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_data)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    fun submitClickHandler(view: View) {
        val ointent = Intent(this, outputScreen::class.java)

        //retrieving data from the input fields
        val ageNum: EditText = findViewById(R.id.ageInput)
        val maleRadioButton: RadioButton = findViewById(R.id.maleRadioButton)
        val femaleRadioButton: RadioButton = findViewById(R.id.female_radio_button)
        val gamingHobby: CheckBox = findViewById(R.id.box_gaming)
        val readingHobby: CheckBox = findViewById(R.id.box_reading)
        val codingHobby: CheckBox = findViewById(R.id.box_coding)
        val sleepingHobby: CheckBox = findViewById(R.id.box_sleeping)
        val usernameData = intent.getStringExtra("UNAME")
        val passwordData = intent.getStringExtra("PASSWORD")

        val username: String = usernameData.toString()
        val password: String = passwordData.toString()

        val gender: String = when {
            maleRadioButton.isChecked -> "Male"
            femaleRadioButton.isChecked -> "Female"
            else -> "Gender not specified"
        }

        val hobbies = arrayListOf<String>()

        if (gamingHobby.isChecked) hobbies.add("Gaming")
        if (readingHobby.isChecked) hobbies.add("Reading")
        if (codingHobby.isChecked) hobbies.add("Coding")
        if (sleepingHobby.isChecked) hobbies.add("Sleeping")

        val age: String = ageNum.text.toString()

        ointent.putExtra("AGE", age)
        ointent.putExtra("GENDER", gender)
        ointent.putStringArrayListExtra("HOBBIES", ArrayList(hobbies))
        ointent.putExtra("USERNAME", username)
        ointent.putExtra("PASSWORD", password)

        startActivity(ointent)
    }
}
