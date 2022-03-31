package com.test.makers_edu_app.presentation.ui.fragments.account

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.makers_edu_app.R
import com.test.makers_edu_app.databinding.FragmentAccountBinding

class AccountFragment : Fragment(R.layout.fragment_account) {

    private val binding: FragmentAccountBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEdit.setOnClickListener {
            findNavController().navigate(R.id.editAccountFragment)
        }

        binding.cvCourse.setOnClickListener {
            findNavController().navigate(R.id.courseFragment)
        }
    }
}