//---------------------------------------------------------- Profile Fragment view
package com.example.randomuser.profile.view
//---------------------------------------------------------- Imports
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.randomuser.databinding.FragmentProfileBinding
import com.example.randomuser.profile.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Profile Fragment view
 */
@AndroidEntryPoint
class ProfileFragment : Fragment() {
    //------------------------------------------------------ Variables
    private val profileViewModel: ProfileViewModel by viewModels()
    private lateinit var binding: FragmentProfileBinding
    //------------------------------------------------------ Constructor
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        initialize()
        return binding.root
    }
    //------------------------------------------------------ Methods
    private fun initialize() {
        profileViewModel.getRandomUser()
    }
}