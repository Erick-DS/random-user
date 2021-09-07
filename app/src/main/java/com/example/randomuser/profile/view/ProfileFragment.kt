//---------------------------------------------------------- Profile Fragment view
package com.example.randomuser.profile.view
//---------------------------------------------------------- Imports
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import com.example.randomuser.databinding.FragmentProfileBinding
import com.example.randomuser.profile.model.UserList
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
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        initialize()
        return binding.root
    }
    //------------------------------------------------------ Methods
    private fun initialize() {
        setObservers()
        setListeners()

        profileViewModel.getRandomUser()
    }

    private fun setObservers() {
        profileViewModel.enableInputs.observe(viewLifecycleOwner, { isEnable ->
            if (this.lifecycle.currentState == Lifecycle.State.RESUMED) {
                binding.buttonGetUser.isEnabled = isEnable
            }
        })

        profileViewModel.progressBar.observe(viewLifecycleOwner, { isVisible ->
            if (this.lifecycle.currentState == Lifecycle.State.RESUMED) {
                binding.progressBar.isVisible = isVisible
            }
        })

        profileViewModel.profileResponse.observe(viewLifecycleOwner, { response ->
            if (this.lifecycle.currentState == Lifecycle.State.RESUMED) {
                displayUserData(response)
            }
        })
    }

    private fun setListeners() {
        binding.buttonGetUser.setOnClickListener(View.OnClickListener {
            profileViewModel.getRandomUser()
        })
    }

    private fun displayUserData(response: UserList) {
        val user = response.results.first()
        val name = user.name.first +" "+ user.name.last

        binding.textViewName.text = name
        binding.textViewEmail.text = user.email
        binding.textViewId.text =  user.id.value
        binding.textViewAge.text = user.dob.age.toString()
        binding.textViewGender.text = user.gender
        binding.textViewCity.text = user.location.city
        binding.textViewCountry.text = user.location.country
    }
}