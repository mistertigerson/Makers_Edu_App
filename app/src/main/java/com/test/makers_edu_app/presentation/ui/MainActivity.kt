package com.test.makers_edu_app.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.auth.FirebaseAuth
import com.test.makers_edu_app.R
import com.test.makers_edu_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()
    private lateinit var navController: NavController
    private val fragments = arrayListOf(
        R.id.mainFragment,
        R.id.searchFragment,
        R.id.accountFragment,
        R.id.educationFragment
    )

    override fun onStart() {
        super.onStart()
        val auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null){
            navController.navigate(R.id.mainFragment)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavController()

    }

    private fun initNavController() {

        val navHostController = supportFragmentManager.findFragmentById(R.id.navHostFragment)
        navController = navHostController!!.findNavController()
        binding.bottomNav.setupWithNavController(navController)

        //скрыть bottomNavigation
        navController.addOnDestinationChangedListener {_, destination, _ ->
            if (fragments.contains(destination.id)) {
                binding.bottomNav.visibility = View.VISIBLE
            } else binding.bottomNav.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        navController.navigate(R.id.mainFragment)
    }
}