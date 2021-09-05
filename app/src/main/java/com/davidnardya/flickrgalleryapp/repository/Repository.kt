package com.davidnardya.flickrgalleryapp.repository

import com.davidnardya.flickrgalleryapp.api.RetrofitInstance
import com.davidnardya.flickrgalleryapp.model.FirstObject


class Repository {
    suspend fun getImages(): FirstObject {
        return RetrofitInstance.api.getImages()
    }

    suspend fun getImages2(number: Int): FirstObject {
        return RetrofitInstance.api.getImages2(number)
    }
}