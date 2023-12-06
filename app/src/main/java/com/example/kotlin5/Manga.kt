package com.example.kotlin5

import androidx.annotation.DrawableRes

data class Manga(
    @DrawableRes
    val image: Int,
    var name: String
)
