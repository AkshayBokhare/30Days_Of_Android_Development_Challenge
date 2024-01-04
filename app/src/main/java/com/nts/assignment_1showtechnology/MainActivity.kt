package com.nts.assignment_1showtechnology

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var screen1TextView : TextView
    private lateinit var screen1Button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screen1Button = findViewById(R.id.screen1_button)
        screen1TextView = findViewById(R.id.screen1_TextView)

        screen1Button.setOnClickListener{

             intent = Intent(applicationContext,SecondActivity::class.java)
            startActivity(intent)

        }

    }
}