package com.example.conduit.service
//import com.squareup.moshi.JsonReader
import androidx.lifecycle.LiveData
import com.example.conduit.data.User
import okhttp3.*
import java.net.URL
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.json.*


//https://realworld-temp-api.herokuapp.com/api/

class UserService(
    override var uri: URL?,
    override var token: String?,
    var user: User?

) : BaseService{
    fun login(email:String,password:String): User? {
        this.user?.email=email
        this.user?.password=password
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/user")
        val json_req_body = "{\"user\":{\"email\":${this.user?.email},\"password\":${this.user?.password}}}"
        val method = "GET"
        val response = this.getData(method, json_req_body)
        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<User>(response.body.toString())
                this.user=obj
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
        return this.user
    }

    fun getUserOne(): User? {
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/user")
        val json_req_body = "{}"
        val method = "GET"
        val response = this.getData(method, json_req_body)

        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<User>(response.body.toString())
                this.user=obj
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
        return this.user
    }

    fun updateUser(requestuser: User): User? {
        this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/user")
        var json_req_body =
            "{ \"user\": { \"email\": ${requestuser.email}, \"token\": ${requestuser.token}, \"username\": ${requestuser.username},\"bio\": ${requestuser.bio}, \"image\": ${requestuser.image} } }"
        val method = "PUT"
        val response = this.setData(method, json_req_body)
        when (response.code) {
            200 -> {
                val obj = Json.decodeFromString<User>(response.body.toString())
                this.user=obj
            }
            401 -> {
                println("Unauthorized")
            }
            422 -> {
                println("Unexpected error")
            }
        }
        return this.user
    }

        fun createUser(requestuser:User): User? {
            this.setApiAddress("https://realworld-temp-api.herokuapp.com/api/user")
            var json_req_body =
                "{ \"user\": { \"email\": ${requestuser.email}, \"username\": ${requestuser.username}, \"password\": ${requestuser.password} } }"
            val method = "POST"
            val response = this.setData(method, json_req_body)

            when (response.code) {
                201 -> {
                    val obj = Json.decodeFromString<User>(response.body.toString())
                    this.user=obj
                }
                422 -> {
                    println("Unexpected error")
                }
            }
            return this.user
        }
    }

