package com.dicoding.farmers.view.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.dicoding.farmers.R
import com.dicoding.farmers.view.onboarding.OnBoardingActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        val splashScreenDuration = 1500L
        lifecycleScope.launch {
            delay(splashScreenDuration)
            startActivity(Intent(this@SplashScreenActivity, OnBoardingActivity::class.java))
        }
    }
}