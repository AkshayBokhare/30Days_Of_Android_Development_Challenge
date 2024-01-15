package com.nts.projectapi_calling

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {


    @GET("users")
    fun getUserData() : Call<MyData>



}