package com.example.randomuser.profile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuser.profile.model.User
import com.example.randomuser.profile.repository.ProfileRepository
import com.example.randomuser.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class ProfileViewModel @javax.inject.Inject constructor(
    private val repository: ProfileRepository
) : ViewModel() {
    //------------------------------------------------------ Variables
    private val _profileResponse = MutableLiveData<Resource<User>>()
    val profileResponse: LiveData<Resource<User>> = _profileResponse
    //------------------------------------------------------ Methods
    fun getRandomUser() {
        viewModelScope.launch {
            _profileResponse.value = Resource.Loading

            when(val response = repository.getRandomUser()) {
                is Resource.Success -> {
                    _profileResponse.postValue(response as Resource<User>?)
                }
                is Resource.Failure<*> -> _profileResponse.value = response
            }
        }
    }
}