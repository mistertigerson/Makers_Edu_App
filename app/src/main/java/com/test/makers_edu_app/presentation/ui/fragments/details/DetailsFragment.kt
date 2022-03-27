package com.test.makers_edu_app.presentation.ui.fragments.details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.makers_edu_app.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private val binding: FragmentDetailsBinding by viewBinding()
   // private val args: DetailsFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
     //   val name: String = args.title.toString()
        val s = arguments?.getString("title")
        binding.tvTitle.text = s
        Log.e("TAG", "onViewCreated: ${s.toString()}", )

    }
}