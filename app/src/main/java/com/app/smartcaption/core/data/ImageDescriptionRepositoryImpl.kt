package com.app.smartcaption.core.data

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import com.app.smartcaption.core.domain.ImageDescriptionRepository
import com.google.mlkit.genai.common.DownloadCallback
import com.google.mlkit.genai.common.FeatureStatus
import com.google.mlkit.genai.common.GenAiException
import com.google.mlkit.genai.imagedescription.ImageDescriber
import com.google.mlkit.genai.imagedescription.ImageDescriptionRequest
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.guava.await
import kotlinx.coroutines.withContext
import okio.IOException
import okio.use
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

class ImageDescriptionRepositoryImpl @Inject constructor(
    private val imageDescriber: ImageDescriber,
    @ApplicationContext private val context: Context
) : ImageDescriptionRepository {

    override fun describeImage(bitmap: Bitmap): Flow<String> = callbackFlow {
        val request = ImageDescriptionRequest.builder(bitmap).build()
        try {
            imageDescriber.runInference(request) { outputText ->
                trySend(outputText)
            }
        } catch (e: Exception) {
            onClose()
        }
    }

    override suspend fun getModelDownloadStatus(): Result<String> {
        val status = imageDescriber.checkFeatureStatus().await()
        return when (status) {
            FeatureStatus.DOWNLOADABLE -> {
                val completed = CompletableDeferred<Unit>()
                imageDescriber.downloadFeature(object : DownloadCallback {
                    override fun onDownloadStarted(bytesToDownload: Long) {}
                    override fun onDownloadFailed(e: GenAiException) {
                        completed.completeExceptionally(e)
                    }

                    override fun onDownloadProgress(totalBytesDownloaded: Long) {}
                    override fun onDownloadCompleted() {
                        completed.complete(Unit)
                    }
                })
                completed.await()
                if (completed.isCompleted)
                    Result.success("Model Downloaded")
                else
                    Result.failure(Exception("Something went wrong."))
            }

            FeatureStatus.DOWNLOADING -> {
                Result.failure(Exception("Model Downloading"))
            }

            FeatureStatus.UNAVAILABLE -> {
                Result.failure(Exception("Model unavailable"))
            }

            else -> {
                Result.success("Model Available")
            }
        }
    }

    override fun onClose() {
        imageDescriber.close()
    }

    override suspend fun saveImage(uri: Uri): Result<Bitmap> {
        return withContext(Dispatchers.IO) {
            try {
                val inputStream = context.contentResolver.openInputStream(uri) ?: throw IOException(
                    "Unable to open input a stream from the Uri."
                )

                val fileName = "Image_${System.currentTimeMillis()}.jpg"
                val file = File(context.filesDir, fileName)
                FileOutputStream(file).use { outputStream ->
                    inputStream.copyTo(outputStream)
                }

                val res = BitmapFactory.decodeFile(file.absolutePath)
                Result.success(res)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}
