package com.nts.fragments_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        replaceWithFragment(CatogoriesFragment())

       val bottomView = findViewById<BottomNavigationView>(R.id.bottomView)

        bottomView.setOnItemSelectedListener {
            when(it.itemId){

                R.id.product_Home -> replaceWithFragment(HomeFragment())
                R.id.user_Profile -> replaceWithFragment(ProfileFragment())
                else -> {

                }
            }
            true
    }
    }


    //Create Function
    private fun replaceWithFragment(fragment: Fragment) {

        val fragmentManager  = supportFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout , fragment)
        fragmentTransaction.commit()
    }


}