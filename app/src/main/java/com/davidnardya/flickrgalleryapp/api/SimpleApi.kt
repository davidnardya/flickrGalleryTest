package com.davidnardya.flickrgalleryapp.api

import com.davidnardya.flickrgalleryapp.model.FirstObject
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {

    @GET("?method=flickr.photos.getRecent")
    suspend fun getImages(
        @Query("page") pageNumber: Int,
        @Query("api_key") api_key: String = "aabca25d8cd75f676d3a74a72dcebf21",
        @Query("format") format: String = "json",
        @Query("extras") extras: String = "url_s",
        @Query("nojsoncallback") nojsoncallback: Int = 1
    ): FirstObject

}