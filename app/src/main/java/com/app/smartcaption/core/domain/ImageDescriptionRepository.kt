package com.app.smartcaption.core.domain

import android.graphics.Bitmap
import android.net.Uri
import kotlinx.coroutines.flow.Flow

interface ImageDescriptionRepository {
    fun onClose()
    fun describeImage(bitmap: Bitmap): Flow<String>
    suspend fun saveImage(uri: Uri): Result<Bitmap>
    suspend fun getModelDownloadStatus(): Result<String>
}