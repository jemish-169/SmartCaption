package com.app.smartcaption.features.history.presentaion

import androidx.annotation.DrawableRes

data class HistoryItem(
    @DrawableRes val img: Int,
    val title: String,
    val description: String
)