package com.davidnardya.flickrgalleryapp.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.davidnardya.flickrgalleryapp.viewmodel.GalleryViewModel

class GalleryViewModelFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GalleryViewModel() as T
    }
}