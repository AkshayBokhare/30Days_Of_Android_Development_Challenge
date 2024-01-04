package com.nts.assignment_2_data_transfer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var startButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.Place_Order)

        startButton.setOnClickListener{

            val intent = Intent(this,SecondActivity::class.java)

            startActivity(intent)

        }

    }
}