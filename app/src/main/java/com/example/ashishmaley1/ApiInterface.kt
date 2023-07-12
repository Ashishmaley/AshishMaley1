package com.example.ashishmaley1

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("10")
    fun getProduct():Call<MemeData>
}