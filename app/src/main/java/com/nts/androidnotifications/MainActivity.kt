package com.nts.androidnotifications

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

   var CHANNEL_ID = "CHANNEL_ID"
   var CHANNEL_NAME = "CHANNEL_NAME"
   var NOTIFICATION_ID = 0

    
    @SuppressLint("MissingPermission", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val frameLayout =findViewById<FrameLayout>(R.id.frame_layout)
       val bottomView = findViewById<BottomNavigationView>(R.id.bottomView)

        //For Notifications
        createNotificationChannel()

       //For Fragments
        replaceWithFragment(HomeFragment())

        bottomView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> replaceWithFragment(HomeFragment())
                R.id.search -> replaceWithFragment(SearchFragment())
                R.id.profile -> replaceWithFragment(ProfileFragment())
                else -> {

                }
            }
            true
        }


        val intent = Intent(this , MainActivity::class.java)
        val pendingintent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_MUTABLE)

        val notification=NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("30Days Of AppDev Challenge")
            .setContentText("Congratulation")
            .setSmallIcon(R.drawable.self)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingintent)
            .build()

        val notificationManager =NotificationManagerCompat.from(this)
        val notifyBtn = findViewById<Button>(R.id.notify_btn)
        notifyBtn.setOnClickListener {

            notificationManager.notify( NOTIFICATION_ID,notification)

        }


    }

    //For Fragemnt
    private fun replaceWithFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout , fragment)
        fragmentTransaction.commit()


    }

    fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val channel = NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
                .apply {
                    description="THis is my notification CHannel"
                    lightColor =Color.CYAN
                    enableLights(true)
                }
            val manager =getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}