package com.example.randomuser.services

import android.content.Context
import com.example.randomuser.profile.model.User
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ProfileService @Inject constructor(
    @ApplicationContext val context: Context,
    private val apiClient: ApiClient
    ) {
    //----------------------------------------------------------- Constants
    suspend fun getRandomUser(): User? {
        val call = apiClient.getRandom()
        call.body()

        if (call.isSuccessful) {
            call.body()?.let { response ->
                return response
            }
        }

        return null
    }
}