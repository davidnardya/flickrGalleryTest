package com.davidnardya.flickrgalleryapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.davidnardya.flickrgalleryapp.api.RetrofitInstance
import com.davidnardya.flickrgalleryapp.api.SimpleApi
import com.davidnardya.flickrgalleryapp.model.Image
import com.davidnardya.flickrgalleryapp.paging.ImagePagingSource
import kotlinx.coroutines.flow.Flow

class GalleryViewModel(): ViewModel() {

    var apiService: SimpleApi = RetrofitInstance.api

    fun getImageList(): Flow<PagingData<Image>> {
        return Pager(config = PagingConfig(pageSize = 10, maxSize = 100),
            pagingSourceFactory = { ImagePagingSource(apiService)}
            ).flow.cachedIn(viewModelScope)
    }
}