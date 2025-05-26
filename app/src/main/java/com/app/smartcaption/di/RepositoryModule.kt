package com.app.smartcaption.di

import android.content.Context
import com.app.smartcaption.core.domain.ImageDescRepository
import com.app.smartcaption.core.data.ImageDescRepositoryImpl
import com.google.mlkit.genai.imagedescription.ImageDescriber
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideImageDescriptionRepository(
        imageDescriber: ImageDescriber,
        @ApplicationContext context: Context
    ): ImageDescRepository =
        ImageDescRepositoryImpl(imageDescriber, context)

}