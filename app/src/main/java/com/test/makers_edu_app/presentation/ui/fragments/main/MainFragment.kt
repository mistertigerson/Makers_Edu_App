package com.test.makers_edu_app.presentation.ui.fragments.main

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.makersproject.presentation.ui.fragments.main.MainModel
import com.test.makers_edu_app.R
import com.test.makers_edu_app.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding()
    private lateinit var adapter: MainAdapter
    private var list: ArrayList<MainModel> = ArrayList()
    private lateinit var mainModel: MainModel
    private lateinit var mainModel2: MainModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(ContentValues.TAG, "onCreate: ")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainModel = MainModel(
            R.drawable.ic_launcher_background,
            "relax",
            "take it easy",
            "ahhahahah"
        )
        mainModel2 = MainModel(
            R.drawable.ic_add_photo,
            "JAva",
            "USA",
            "AUF"
        )
        list.add(mainModel)
        list.add(mainModel2)
        adapter = MainAdapter(object : MainAdapter.ClickOnPlaylist2 {
            override fun onClick(model: MainModel, position: Int) {
                val bundle = Bundle()
                bundle.putSerializable("title", list[position])
                findNavController().navigate(R.id.detailsFragment, bundle)
            }

            override fun clickBtn() {
                findNavController().navigate(R.id.authorizationFragment)
            }

        })
        binding.recyclerMain.adapter = adapter
        adapter.setList(list)





    }

    companion object {
        const val TITLE = "title"
    }
}