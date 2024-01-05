package com.nts.crudoperationwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val intent = getIntent()
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val userId = intent.getStringExtra("name")

     val mailText = findViewById<TextView>(R.id.tvMail)
     val idText = findViewById<TextView>(R.id.tvUnique)
     val nameText = findViewById<TextView>(R.id.tVWelcome)


        mailText.setText("WellCome $name")
        mailText.setText(email)
        idText.setText(userId)
    }
}