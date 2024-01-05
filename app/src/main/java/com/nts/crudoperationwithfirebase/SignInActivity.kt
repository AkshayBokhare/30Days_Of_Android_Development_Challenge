package com.nts.crudoperationwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {

    lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signIn = findViewById<Button>(R.id.btnSignIN)
        val userName = findViewById<TextInputEditText>(R.id.userNameEditText)


        signIn.setOnClickListener {

            val uniqueId = userName.text.toString()
            if (uniqueId.isNotEmpty()){

                readData(uniqueId)

            }else{
                Toast.makeText(this, "Enter Valid Data", Toast.LENGTH_SHORT).show()


            }
        }

    }

     private fun readData(uniqueId: String) {
         databaseReference = FirebaseDatabase.getInstance().getReference("Users")
         databaseReference.child(uniqueId).get().addOnSuccessListener {

             if (it.exists()){

                 val email = it.child("email").value
                 val name  = it.child("name").value
                 val userId = it.child("uniqueId").value

                 val intent = Intent(this,WelcomeActivity::class.java)
                 intent.putExtra("email",email.toString())
                 intent.putExtra("name",name.toString())
                 intent.putExtra("userId",userId.toString())
                 startActivity(intent)

             }else{
                 Toast.makeText(this, "User not exits", Toast.LENGTH_SHORT).show()
             }

         }.addOnFailureListener {

             Toast.makeText(this, "Enter Valid Data OR sIGN uP", Toast.LENGTH_SHORT).show()
         }
    }
}