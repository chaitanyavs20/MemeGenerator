package com.example.chaitanya.memeshareapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val Base_Url = "https://meme-api.com/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMemeData();
    }

    private fun getMemeData() {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIinterface::class.java)

        val retrofitdata = retrofitBuilder.getData()
        println("Hello")
        Log.d("mAINacT","Hello")

        val imageview: ImageView = findViewById(R.id.memeImage)

       retrofitdata.enqueue(object : Callback<MemeList> {

           override fun onResponse(call: Call<MemeList>, response: Response<MemeList>) {
               Log.d("onResponding","Success123")
               //TODO("Not yet implemented")
               val responseBody = response.body()
               val memeBody = responseBody?.memes
               Log.d("onResponding12345","Success12345")
               val uri= memeBody?.get(0)?.url.toString()
               println(uri)
               Glide.with(this@MainActivity).load(uri).into(imageview)

               Log.d("onResponse","Success")
           }

           override fun onFailure(call: Call<MemeList>, t: Throwable) {
               TODO("Not yet implemented")
               Log.d("onFailure","Failure")
           }
       })

    }

    fun ShareMeme(view: View) {}
    fun NextMeme(view: View) {}
}