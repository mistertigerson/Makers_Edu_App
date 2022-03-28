package com.test.makers_edu_app.presentation.ui.fragments.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.makers_edu_app.R
import com.test.makers_edu_app.databinding.FragmentSearchBinding

class SearchFragment : Fragment(R.layout.fragment_search) {

    private  val  binding : FragmentSearchBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}