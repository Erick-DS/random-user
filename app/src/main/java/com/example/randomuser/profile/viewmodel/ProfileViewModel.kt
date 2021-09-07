//---------------------------------------------------------- Profile View Model
package com.example.randomuser.profile.viewmodel
//---------------------------------------------------------- Imports
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuser.profile.model.User
import com.example.randomuser.profile.repository.ProfileRepository
import com.example.randomuser.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

/**
 * Profile View Model
 */
@HiltViewModel
class ProfileViewModel @javax.inject.Inject constructor(
    private val repository: ProfileRepository
) : ViewModel() {
    //------------------------------------------------------ Variables
    private val _profileResponse = MutableLiveData<User>()
    val profileResponse: LiveData<User> = _profileResponse

    val enableInputs = MutableLiveData<Boolean>()
    val progressBar = MutableLiveData<Boolean>()
    val errorUser = MutableLiveData<String>()
    //------------------------------------------------------ Methods
    fun getRandomUser() {
        progressBar.postValue(true)
        enableInputs.postValue(false)

        viewModelScope.launch {
            when(val response = repository.getRandomUser()) {
                is Resource.Success -> {
                    _profileResponse.postValue(response.data!!)
                    progressBar.postValue(false)
                    enableInputs.postValue(true)
                }
                is Resource.Failure<*> -> {
                    errorUser.value = "error"
                    progressBar.postValue(false)
                    enableInputs.postValue(true)
                }
            }
        }
    }
}