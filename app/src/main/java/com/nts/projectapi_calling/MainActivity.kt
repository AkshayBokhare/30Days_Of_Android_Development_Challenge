package com.nts.projectapi_calling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

       val baseURL = "https://dummyjson.com/"

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

            val retrofitData =retrofitBuilder.getUserData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                //Fetch Data From Api And Set Adapter
                   var responseBoday = response.body()
                  val userList= responseBoday?.users !!

                // Set Adapter
                myAdapter = MyAdapter(this@MainActivity,userList)
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)


                }override fun onFailure(call: Call<MyData?>, t: Throwable) {
               // If Data Not fetch Then Show or THrow Error
            }


        })

    }
}