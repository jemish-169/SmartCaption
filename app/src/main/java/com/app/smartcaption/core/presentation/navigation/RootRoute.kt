package com.app.smartcaption.core.presentation.navigation

import kotlinx.serialization.Serializable

sealed class RootRoute {

    // screens are listed here

    @Serializable
    data object HomeScreen : RootRoute()

    @Serializable
    data object UploadScreen : RootRoute()

    @Serializable
    data class CaptionScreen(val imgUri: String) : RootRoute()

    @Serializable
    data object HistoryScreen : RootRoute()
}