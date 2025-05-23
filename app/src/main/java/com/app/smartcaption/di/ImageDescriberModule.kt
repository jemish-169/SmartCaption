package com.app.smartcaption.di

import android.content.Context
import com.google.mlkit.genai.imagedescription.ImageDescriber
import com.google.mlkit.genai.imagedescription.ImageDescriberOptions
import com.google.mlkit.genai.imagedescription.ImageDescription
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ImageDescriberModule {


    @Provides
    @Singleton
    fun provideImageDescriber(@ApplicationContext context: Context): ImageDescriber {
        val options = ImageDescriberOptions.builder(context).build()
        return ImageDescription.getClient(options)
    }
}