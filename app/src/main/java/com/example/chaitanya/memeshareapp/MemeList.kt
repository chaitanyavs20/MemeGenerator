package com.example.chaitanya.memeshareapp

import com.example.chaitanya.memeshareapp.Meme

data class MemeList(
    val count: Int,
    val memes: List<Meme>
)