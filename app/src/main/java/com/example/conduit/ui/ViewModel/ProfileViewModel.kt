package com.example.conduit.ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conduit.data.Profile
import com.example.conduit.data.User
import com.example.conduit.service.ProfileService
import kotlinx.coroutines.launch
//others
class ProfileViewModel : ViewModel() {


    private val _userResponse= MutableLiveData<User>()
    val userResponse: LiveData<User> =_userResponse
    private val _profileResponse= MutableLiveData<Profile>()
    val profileResponse: LiveData<Profile> =_profileResponse
    private val _userRes= MutableLiveData<User>()
    val userRes: LiveData<User> =_userRes

//    fun setProfile(userName: String,email: String,bio:String,image:String,password:String){
//        viewModelScope.launch {
//            val updateProfileRequest= ProfileService(null,null,null,)
//                UpdateUserProfileEntity(
//                    username = userName,
//                    email = email,
//                    bio = bio,
//                    image = image,
//                    password = password,
//
//                    )
//            )
//            ConduitClient.authApi.updateProfile(updateProfileRequest).let {
//                _userResponse.postValue(it.body())
//            }
//        }
//    }
//
//    fun getProfileInfo(userName:String){
//        viewModelScope.launch {
//            var profileService=ProfileService(null,null,null)
//            UserAuthRepo.getUserProfile(userName).let {
//                _profileResponse.postValue(it.body())
//            }
//        }
//    }
//
//    fun getCurrentUserInfo(){
//        viewModelScope.launch {
//            UserAuthRepo.getCurrentUser().let {
//                _userRes.postValue(it.body())
//            }
//        }
//    }
}