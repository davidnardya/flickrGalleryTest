package com.davidnardya.flickrgalleryapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.davidnardya.flickrgalleryapp.api.RetrofitInstance
import com.davidnardya.flickrgalleryapp.api.SimpleApi
import com.davidnardya.flickrgalleryapp.model.FirstObject
import com.davidnardya.flickrgalleryapp.model.Image
import com.davidnardya.flickrgalleryapp.paging.ImagePagingSource
import com.davidnardya.flickrgalleryapp.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class GalleryViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<FirstObject> = MutableLiveData()
    val myResponse2: MutableLiveData<FirstObject> = MutableLiveData()

    lateinit var apiService: SimpleApi

    init {
        apiService = RetrofitInstance.api
    }

    fun getImages(){
        viewModelScope.launch {
            val response = repository.getImages()
            myResponse.value = response
        }
    }

    fun getImages2(number: Int){
        viewModelScope.launch {
            val response = repository.getImages2(number)
            myResponse2.value = response
        }
    }

    suspend fun getImageList(): Flow<PagingData<Image>> {
        return Pager(config = PagingConfig(pageSize = 10, maxSize = 100),
            pagingSourceFactory = { ImagePagingSource(apiService)}
            ).flow.cachedIn(viewModelScope)
    }
}