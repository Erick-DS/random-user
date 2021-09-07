//------------------------------------------------------------- Profile Service
package com.example.randomuser.services
//------------------------------------------------------------- Imports
import android.content.Context
import android.widget.Toast
import com.example.randomuser.R
import com.example.randomuser.profile.model.User
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * Profile service to get random user
 */
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
        } else {
            val messageError = context.resources.getString(R.string.error_contact_server)
            Toast.makeText(context, messageError, Toast.LENGTH_SHORT).show()
        }

        return null
    }
}