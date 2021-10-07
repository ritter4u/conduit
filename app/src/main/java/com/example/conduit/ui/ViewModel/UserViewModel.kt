package com.example.conduit.ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conduit.data.User
import com.example.conduit.service.UserService
import kotlinx.coroutines.launch

//data class SignInUiState(
//    val loading: Boolean = false,
//)
class UserViewModel : ViewModel() {
    private val _userInfo= MutableLiveData<User?>()
    val userInfo: LiveData<User?> = _userInfo
    var user=userInfo.value
    val userservice:UserService=UserService(
        null,
        user?.token,
        user)
    fun userLoginRequest(email: String, password:String){
        viewModelScope.launch{
            userservice.login(email,password)?.let {
                _userInfo.postValue(it)
            }
        }
    }
    fun addUser(userRequests: User){
        viewModelScope.launch {
            val user: Unit =userservice.createUser(userRequests).let{
                _userInfo.postValue(it)
            }
        }
    }
    fun updateUser(userRequests: User){
        viewModelScope.launch {
            val user: Unit =userservice.updateUser(userRequests).let{
                _userInfo.postValue(it)
            }
        }
    }
    fun getProfileInfo(){
        viewModelScope.launch {

            val user: Unit =userservice.getUserOne().let{
                _userInfo.postValue(it)
            }
        }
    }

//    fun deleteUser(userRequests: User){
//        viewModelScope.launch {
//            val userservice:UserService=UserService(null,null,null)
//            val user: Unit =userservice.d(userRequests).let{
//                _userInfo.postValue(it)
//            }
//        }
//    }
}
