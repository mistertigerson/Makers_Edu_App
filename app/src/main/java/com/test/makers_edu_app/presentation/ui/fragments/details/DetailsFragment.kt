package com.test.makers_edu_app.presentation.ui.fragments.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.makersproject.presentation.ui.fragments.main.MainModel
import com.test.makers_edu_app.R
import com.test.makers_edu_app.databinding.FragmentDetailsBinding
import com.test.makers_edu_app.presentation.ui.fragments.main.MainFragment.Companion.TITLE


class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val binding: FragmentDetailsBinding by viewBinding()
    private lateinit var model : MainModel

    // private val args: DetailsFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = arguments?.get("title") as MainModel
        getArgs()


    }


    fun getArgs() = with(binding) {
        binding.tvTitle.text = model.title
        binding.ivIcon.setImageResource(model.imageIcon)
        binding.tvNameOfAuthor.text = model.NameOfAuthor
        binding.tvComments.text = model.comments

    }
}