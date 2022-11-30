package com.example.chaitanya.memeshareapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface APIinterface {

    @GET("gimme")
    fun getData(): Call<MemeData>
}

object MemeCall{
    val meme:APIinterface
    init {
        val retrofitbuilder = Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        meme = retrofitbuilder.create(APIinterface::class.java)
    }
}