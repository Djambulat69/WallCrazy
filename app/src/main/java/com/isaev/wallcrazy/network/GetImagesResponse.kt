package com.isaev.wallcrazy.network

import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class GetImagesResponse(
    @SerialName("total") val total: Int,
    @SerialName("hits") val images: List<Image>
)

@kotlinx.serialization.Serializable
data class Image(
    @SerialName("id") val id: Long,
    @SerialName("largeImageURL") val largeUrl: String
)