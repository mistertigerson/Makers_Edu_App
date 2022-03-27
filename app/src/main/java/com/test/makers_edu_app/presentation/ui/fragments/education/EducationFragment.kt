package com.test.makers_edu_app.presentation.ui.fragments.education

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.test.makers_edu_app.R
import com.test.makers_edu_app.databinding.FragmentEducationBinding


class EducationFragment : Fragment(R.layout.fragment_education) {
    private val binding: FragmentEducationBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgSecondFragment.setOnClickListener {
            pickImg()
        }
    }

    private fun pickImg() {
        Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        ).apply {
            type = "image/*"
            registerForActivity.launch(this)
        }
    }

    private val registerForActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val filePath: Uri = it.data!!.data!!
                Glide.with(requireContext()).load(filePath).into(binding.imgSecondFragment)
            }
        }
}
