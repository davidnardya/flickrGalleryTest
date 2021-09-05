package com.davidnardya.flickrgalleryapp.api

import com.davidnardya.flickrgalleryapp.model.FirstObject
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {

    @GET("?method=flickr.photos.getRecent&extras=url_s&api_key=aabca25d8cd75f676d3a74a72dcebf21&format=json&page=1&nojsoncallback=1")
    suspend fun getImages(): FirstObject

    @GET("?method=flickr.photos.getRecent&extras=url_s&api_key=aabca25d8cd75f676d3a74a72dcebf21&format=json&page=pageNumber&nojsoncallback=1")
    suspend fun getImages2(
        @Query("pageNumber&nojsoncallback=1") pageNumber: Int
    ): FirstObject

}