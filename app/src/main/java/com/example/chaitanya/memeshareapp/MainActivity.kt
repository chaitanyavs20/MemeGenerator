package com.example.chaitanya.memeshareapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val Base_Url = "https://meme-api.herokuapp.com/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMemeData();
    }

    private fun getMemeData() {
//        val retrofitBuilder = Retrofit.Builder()
//            .baseUrl(Base_Url)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(APIinterface::class.java)
//
//        val retrofitdata = retrofitBuilder.getData()
//        println("Hello")
        //Log.d("mAINacT","Hello")

        val memes = MemeCall.meme.getData()
        val imageview: ImageView = findViewById(R.id.memeImage)
        memes.enqueue(object:Callback<MemeData>{
            override fun onFailure(call: Call<MemeData>, t: Throwable) {
                Log.d("Activity",t.localizedMessage.toString())
            }

            override fun onResponse(call: Call<MemeData>, response: Response<MemeData>) {
//                val meme1: MemeList? = response.body()
               // Log.d("MainActivity", response.body()?.url.toString())
                val uri= response.body()?.url.toString()
                Glide.with(this@MainActivity).load(uri).into(imageview)
            }


        })
      /*  val imageview: ImageView = findViewById(R.id.memeImage)
        println(imageview)

        retrofitdata.enqueue(object:Callback<List<MemeData>?>{
            override fun onResponse(call: Call<List<MemeData>?>, response: Response<List<MemeData>?>){
                val responseBody = response.body()!!

                val myStringBuilder = JsonArray()

                val imageview: ImageView = findViewById(R.id.memeImage)
                println(imageview)
                for(myData in responseBody){
                    val uri = myStringBuilder.add(myData.url)
                    Glide.with(this@MainActivity).load(uri).into(imageview)
                }

            }

            override fun onFailure(call: Call<List<MemeData>?>, t: Throwable) {
                Log.d("MainActivity",t.localizedMessage.toString())
            }
        })*/
    }

    fun ShareMeme(view: View) {}
    fun NextMeme(view: View) {}
}