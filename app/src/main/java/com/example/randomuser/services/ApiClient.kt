package com.example.randomuser.services

import com.example.randomuser.profile.model.User
import retrofit2.Response
import retrofit2.http.*

/**
 * Api client for retrofit to use with all services
 */
interface ApiClient {
    companion object {
        const val BASE_URL = "https://randomuser.me/"
    }
    /**
     * Service GET method to get random user from endpoint
     */
    @Headers("Accept: application/json", "Content-type:application/json")
    @GET("api/")
    suspend fun getRandom(): Response<User>
}
