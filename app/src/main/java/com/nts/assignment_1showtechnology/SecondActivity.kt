package com.nts.assignment_1showtechnology

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat

class SecondActivity : AppCompatActivity() {

    lateinit var callusButton :Button
    lateinit var card1:CardView
    lateinit var card2:CardView
    lateinit var card3: CardView
    lateinit var card4: CardView
    lateinit var card5: CardView
    lateinit var card6: CardView
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar?.title = "Departments"

        callusButton = findViewById(R.id.callus_button)
        card1 = findViewById(R.id.card_1)
        card2 = findViewById(R.id.card_2)
        card3 = findViewById(R.id.card_3)
        card4 = findViewById(R.id.card_4)
        card5 = findViewById(R.id.card_5)
        card6 = findViewById(R.id.card_6)

        checkPermision()

        callusButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" +"8380828898")
                startActivity(intent)
        }

        card1.setOnClickListener{
            val intent = Intent(this,AndroidDeveloper::class.java)
            startActivity(intent)

        }

        card2.setOnClickListener{
            val intent = Intent(this,WebDeveloper::class.java)
            startActivity(intent)

        }
        card3.setOnClickListener{
            val intent = Intent(this,IOSDeveloper::class.java)
            startActivity(intent)

        }
        card4.setOnClickListener{
            val intent = Intent(this,BackEndDeveloper::class.java)
            startActivity(intent)

        }
        card5.setOnClickListener{
            val intent = Intent(this,RPADeveloper::class.java)
            startActivity(intent)

        }
        card6.setOnClickListener{
            val intent = Intent(this,PythonDeveloper::class.java)
            startActivity(intent)

        }

    }




















    private fun checkPermision(){
        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE)
            !=PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),101)
        }else{
            Toast.makeText(this@SecondActivity,"Grant Permision to make call",Toast.LENGTH_SHORT).show()
        }
    }
}