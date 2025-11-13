package com.QuickMenu.mobile.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.QuickMenu.mobile.R
import androidx.navigation.findNavController
import com.QuickMenu.mobile.databinding.ActivitySplashBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        /*checkAuth()*/


    }

    private fun checkAuth(){

        val navController = binding.main.findNavController()

        val isUserLoggedIn = auth.currentUser != null

        if(isUserLoggedIn){
            navController.navigate(R.id.action_splash_to_main)
        }
        else{
            navController.navigate(R.id.action_splash_to_auth)
        }

    }
    override fun onDestroy() {
        super.onDestroy()
    }
}