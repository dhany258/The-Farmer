package com.dicoding.farmers

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.dicoding.farmers.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.buttonNavigation
        val navController = binding.navHostFragmentContainer.getFragment<NavHostFragment>().navController
        navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> navView.visibility = View.VISIBLE
                R.id.addFragment-> navView.visibility = View.VISIBLE
                R.id.accountFragment -> navView.visibility = View.VISIBLE
                else -> navView.visibility = View.GONE
            }
        }
    }
}