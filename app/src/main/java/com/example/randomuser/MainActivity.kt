//--------------------------------------------------------------- Main Activity
package com.example.randomuser
//--------------------------------------------------------------- Imports
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.randomuser.profile.view.ProfileFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main Activity to host fragments
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //----------------------------------------------------------- Constructor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayProfileFragment()
    }
    //----------------------------------------------------------- Methods
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    private fun displayProfileFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction().addToBackStack(null)
        val fragment = ProfileFragment()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}