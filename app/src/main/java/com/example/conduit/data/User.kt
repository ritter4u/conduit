package com.example.conduit.data
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User (
    @Json(name = "email")
    var email: kotlin.String,
    @Json(name = "token")
    val token: kotlin.String,
    @Json(name = "username")
    val username: kotlin.String,
    @Json(name = "bio")
    val bio: kotlin.String,
    @Json(name = "image")
    val image: kotlin.String,
    @Json(name = "password")
    var password: kotlin.String
)