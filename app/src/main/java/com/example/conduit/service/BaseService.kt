package com.example.conduit.service

import android.webkit.JsResult
import kotlinx.serialization.json.JsonNull.content
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.net.URL
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody

interface BaseService {
    var uri: URL?
    var token: String?
    fun setApiAddress(url: String): Unit {
//        val url = URL("https://realworld-temp-api.herokuapp.com/api/user")
        this.uri = URL(url)
        return Unit
    }

    fun getApiAddress(): URL? {
        return this.uri
    }

    fun getData(method: String, json_req_body: String): Response {
        val url = this.getApiAddress()
        val client = OkHttpClient()
        val JSON = "application/json; charset=utf-8".toMediaType()
        val body = json_req_body.toRequestBody(JSON)

        val request = Request.Builder()
        when (this.token != "") {
            true -> {
                request.addHeader("Authorization", "Bearer ${this.token}")
            }
            false -> {
            }
        }
        request.url(url!!)

        when (method) {
            "GET" -> {
                request.get()
            }
            "POST" -> {
                request.post(body)
            }
            "PUT" -> {
                request.put(body)
            }
            "DELETE" -> {
                request.delete(body)
            }
            else -> {
            }
        }
        val build = request.build()
        return client.newCall(build).execute()
    }

    fun setData(method: String, json_req_body: String): Response {
        val url = this.getApiAddress()
        val client = OkHttpClient()
        val JSON = "application/json; charset=utf-8".toMediaType()

        val body = json_req_body.toRequestBody(JSON)

        val request = Request.Builder()
        when (this.token != "") {
            true -> {
                request.addHeader("Authorization", "Bearer ${this.token}")
            }
            false -> {
            }
        }
        request.url(url!!)
        when (method) {
            "GET" -> {
                request.get()
            }
            "POST" -> {
                request.post(body)
            }
            "PUT" -> {
                request.put(body)
            }
            "DELETE" -> {
                request.delete(body)
            }
            else -> {
            }
        }
        val build = request.build()
        return client.newCall(build).execute()
    }
}