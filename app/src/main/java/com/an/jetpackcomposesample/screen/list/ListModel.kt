package com.an.jetpackcomposesample.screen.list

import androidx.annotation.DrawableRes

data class ListModel (
    val id: Int,
    @DrawableRes val image: Int,
    val name: String,
    val desc: String
)