package com.isaev.wallcrazy.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesApiService {

    @GET("api")
    suspend fun getImages(
        @Query("key") apiKey: String,
        @Query("category") category: String,
        @Query("safesearch") safeSearch: Boolean,
        @Query("page") page: Int
    ): GetImagesResponse

}