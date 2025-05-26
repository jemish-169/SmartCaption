package com.app.smartcaption.core.presentation.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.smartcaption.core.domain.ImageDescRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageDescViewModel @Inject constructor(
    private val imgDescRepository: ImageDescRepository
) : ViewModel() {

    private val _messageFlow = MutableStateFlow("")
    val messageFlow: StateFlow<String> = _messageFlow


    private val _successFlow = MutableStateFlow("")
    val successFlow: StateFlow<String> = _successFlow

    fun getImageDescription(uri: Uri) {
        viewModelScope.launch {
            imgDescRepository.getModelDownloadStatus().fold(
                onSuccess = {
                    imgDescRepository.saveImage(uri).fold(
                        onSuccess = { bitmap ->
                            imgDescRepository.describeImage(bitmap).let { msg ->
                                _successFlow.update { it.plus(msg) }
                            }
                        },
                        onFailure = { exception ->
                            _messageFlow.update { exception.message ?: "Image Bitmap was null" }
                        }
                    )
                },
                onFailure = { exception ->
                    _messageFlow.update { exception.message ?: "Model has some issue" }
                }
            )
        }
    }
}