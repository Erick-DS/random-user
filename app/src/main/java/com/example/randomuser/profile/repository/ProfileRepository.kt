//-------------------------------------------------------------- Profile Repository
package com.example.randomuser.profile.repository
//-------------------------------------------------------------- imports
import com.example.randomuser.profile.model.User
import com.example.randomuser.services.ProfileService
import com.example.randomuser.utils.Resource
import java.lang.Exception
import javax.inject.Inject

/**
 * Profile Repository
 */
class ProfileRepository @Inject constructor(
    private val profileService: ProfileService
) {
    //----------------------------------------------------------- Methods
    suspend fun getRandomUser(): Resource<User?> {
        return try {
            val response = profileService.getRandomUser()
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Failure<Nothing>(e)
        }
    }
}