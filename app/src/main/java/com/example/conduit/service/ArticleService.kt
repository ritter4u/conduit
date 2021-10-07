package com.example.conduit.service

import com.example.conduit.data.Article
import com.example.conduit.data.User
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.net.URL

//https://realworld-temp-api.herokuapp.com/api/
class ArticleService(override var uri: URL?, override var token: String?) : BaseService {
    fun getFeed() {
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/articles/feed")
        val json_req_body = "{}"
        val method = "GET"
        val response = this.getData(method, json_req_body)

        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<Article>(response.body.toString())
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
    }
    fun getArticles() {
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/articles")
        val json_req_body = "{}"
        val method = "GET"
        val response = this.getData(method, json_req_body)

        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<Article>(response.body.toString())
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
    }
    fun createArticle() {
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/articles")
        val json_req_body = "{}"
        val method = "POST"
        val response = this.getData(method, json_req_body)

        when (response.code) {
            201 -> {
                val obj = Json.decodeFromString<Article>(response.body.toString())
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
    }
    fun getArticle(slug:String) {
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/articles/${slug}")
        val json_req_body = "{}"
        val method = "POST"
        val response = this.getData(method, json_req_body)

        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<Article>(response.body.toString())
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
    }
    fun updateArticle(slug:String){
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/articles/${slug}")
        val json_req_body = "{}"
        val method = "PUT"
        val response = this.getData(method, json_req_body)

        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<Article>(response.body.toString())
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
    }

    fun deleteArticle(slug:String) {
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/articles/${slug}")
        val json_req_body = "{}"
        val method = "DELETE"
        val response = this.getData(method, json_req_body)

        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<Article>(response.body.toString())
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
    }

    fun getComment(slug:String) {
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/articles/${slug}/comments")
        val json_req_body = "{}"
        val method = "GET"
        val response = this.getData(method, json_req_body)

        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<Article>(response.body.toString())
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
    }
    fun updateComment(slug:String) {
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/articles/${slug}/comments")
        val json_req_body = "{}"
        val method = "POST"
        val response = this.getData(method, json_req_body)

        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<Article>(response.body.toString())
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
    }
    fun deleteComment(slug:String,id:Int) {
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/articles/${slug}/comments/${id}")
        val json_req_body = "{}"
        val method = "DELETE"
        val response = this.getData(method, json_req_body)

        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<Article>(response.body.toString())
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
    }
    fun updateFavorite(slug:String) {
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/articles/${slug}/favorite")
        val json_req_body = "{}"
        val method = "POST"
        val response = this.getData(method, json_req_body)

        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<Article>(response.body.toString())
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
    }
    fun deleteFavorite(slug:String) {
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/articles/${slug}/favorite")
        val json_req_body = "{}"
        val method = "DELETE"
        val response = this.getData(method, json_req_body)

        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<Article>(response.body.toString())
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
    }

    fun getTags(){
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/tags")
        val json_req_body = "{}"
        val method = "GET"
        val response = this.getData(method, json_req_body)

        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<Article>(response.body.toString())
            }
            422 -> {
                println("Unexpected error")
            }
        }
    }
}