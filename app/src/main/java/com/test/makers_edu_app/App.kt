package com.test.makers_edu_app

import android.app.Application
import com.google.firebase.auth.FirebaseAuth

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        fbAuth = FirebaseAuth.getInstance()
    }

    companion object{
        lateinit var fbAuth: FirebaseAuth
        lateinit var authListener: FirebaseAuth.AuthStateListener
    }
}