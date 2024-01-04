package com.nts.assignment_2_data_transfer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivity : AppCompatActivity() {

    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var editText3: EditText
    lateinit var placeOrder: Button

//companion object{
//         const val KEY ="com.nts.assignment_2_data_transfer.KEY"
//}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        editText1 =findViewById(R.id.eT_1)
        editText2 =findViewById(R.id.eT_2)
        editText3 =findViewById(R.id.eT_3)
        placeOrder =findViewById(R.id.Place_Order)


        placeOrder.setOnClickListener {

            val orderone = editText1.text.toString()
            val ordertwo = editText2.text.toString()
            val orderthree = editText3.text.toString()

            val intent = Intent(this,DispalyOrder::class.java)
            intent.putExtra("getorder1",orderone)
            intent.putExtra("getorder2",ordertwo)
            intent.putExtra("getorder3",orderthree)
            startActivity(intent)


        }


    }
}