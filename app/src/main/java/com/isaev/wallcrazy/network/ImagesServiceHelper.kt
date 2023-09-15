package com.isaev.wallcrazy.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object ImagesServiceHelper {

    private const val BASE_URL = "https://pixabay.com/"
    private const val API_KEY = "39448421-66dd0868b598f0d8c885d45b2"

    private val json: Json = Json { ignoreUnknownKeys = true }

    private val retrofitService =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                json.asConverterFactory(MediaType.get("application/json"))
            )
            .build()
            .create(ImagesApiService::class.java)


    suspend fun getImages(category: com.isaev.wallcrazy.Category, page: Int): List<Image> =
        retrofitService.getImages(
            API_KEY, category.name, true, page
        ).images

}
