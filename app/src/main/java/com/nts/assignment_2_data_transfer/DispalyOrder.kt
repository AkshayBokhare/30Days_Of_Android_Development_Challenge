package com.nts.assignment_2_data_transfer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class DispalyOrder : AppCompatActivity() {

    lateinit var order1 : TextView
    lateinit var order2 : TextView
    lateinit var order3 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dispaly_order)

        order1 = findViewById(R.id.order1)
        order2 = findViewById(R.id.order2)
        order3 = findViewById(R.id.order3)


       val intent = getIntent()
       var getor1 = intent.getStringExtra("getorder1")
       var getor2 = intent.getStringExtra("getorder2")
       var getor3 = intent.getStringExtra("getorder3")

        order1.text=getor1
        order2.text=getor2
        order3.text=getor3



    }
}