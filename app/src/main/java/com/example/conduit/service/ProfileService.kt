package com.example.conduit.service

import com.example.conduit.data.Article
import com.example.conduit.data.Profile
import com.example.conduit.data.User
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.net.URL

//https://realworld-temp-api.herokuapp.com/api/profile/{username}
//https://realworld-temp-api.herokuapp.com/api/profile/{username}/follow
class ProfileService(
    override var uri: URL?,
    override var token: String?,
    var profile: Profile?,
    ) : BaseService {
    fun getProfiles() {
//        this.profile?.username=username
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/profile/${this.profile?.username}")
        val json_req_body = "{}"
        val method = "GET"
        val response = this.getData(method, json_req_body)
        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<Profile>(response.body.toString())
                this.profile=obj
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
    }
    fun updateProfile(username:String) {
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/profile/${this.profile?.username}/follow")
        val json_req_body = "{}"
        val method = "POST"
        val response = this.getData(method, json_req_body)
        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<Profile>(response.body.toString())
                this.profile=obj
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
    }
    fun deleteProfile(username:String) {
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/profile/${this.profile?.username}/follow")
        val json_req_body = "{}"
        val method = "DELETE"
        val response = this.getData(method, json_req_body)
        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<Profile>(response.body.toString())
                this.profile=obj
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
    }
}