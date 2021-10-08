package com.example.conduit.ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conduit.data.Article
import com.example.conduit.data.Profile
import com.example.conduit.data.User
import com.example.conduit.service.ArticleService
import com.example.conduit.service.ProfileService
import com.example.conduit.service.UserService
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

//others
class ArticleViewModel : ViewModel(

) {
    private val _articleResponse= MutableLiveData<Article>()
    val articleResponse: LiveData<Article> =_articleResponse
    private val _userRes= MutableLiveData<User>()
    val userRes: LiveData<User> =_userRes
    private val _userInfo= MutableLiveData<User?>()
    val userInfo: LiveData<User?> = _userInfo
    var user=userInfo.value
    val userservice: UserService = UserService(
        null,
        user?.token,
        user)
    val articleservice= ArticleService(null,user?.token)
    fun getArticles(){
//        viewModelScope.launch {
//            val article: Unit =articleservice.getArticles().let{
//                _articleResponse.postValue(it)
//            }
//        }
    }
    fun getArticle(){
//        viewModelScope.launch {
//            val article: Unit =articleservice.getArticles().let{
//                _articleResponse.postValue(it)
//            }
//        }
    }
    fun getFavorite(){}
    fun updateArticle(){}
    fun createArticle(){}
    fun getFeed(){}
    fun getComment(slug:String) {}
    fun updateComment(slug:String) {}
    fun deleteComment(slug:String,id:Int) {}
    fun updateFavorite(slug:String) {}
    fun deleteFavorite(slug:String) {}
    fun getTags(){}
}

