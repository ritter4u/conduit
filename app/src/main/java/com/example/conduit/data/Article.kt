package com.example.conduit.data

import com.squareup.moshi.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


@JsonClass(generateAdapter = true)
data class Article (
    @Json(name = "slug")
    val slug: kotlin.String,
    @Json(name = "title")
    val title: kotlin.String,
    @Json(name = "description")
    val description: kotlin.String,
    @Json(name = "body")
    val body: kotlin.String,
    @Json(name = "tagList")
    val tagList: kotlin.Array<String>,
    @Json(name = "createdAt") //datetime
    val createdAt: Date,
    @Json(name = "updatedAt")
    val updatedAt: Date,
    @Json(name = "favorited")
    val favorited: kotlin.Boolean,
    @Json(name = "favoritesCount")
    val favoritesCount: kotlin.Int,
    @Json(name = "author")
    val author: Any = object {
        val username:String=""
        val bio:String =""
        val image:String=""
        val folloing:Boolean=false
    }

)

