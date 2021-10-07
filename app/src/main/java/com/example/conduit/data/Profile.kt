package com.example.conduit.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Profile (
    @Json(name = "username")
    var username: kotlin.String,
    @Json(name = "bio")
    val bio: kotlin.String,
    @Json(name = "image")
    val image: kotlin.String,
    @Json(name = "following")
    val following: kotlin.Boolean
)
