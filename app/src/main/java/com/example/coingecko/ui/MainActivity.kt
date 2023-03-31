package com.example.coingecko.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration

import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.coingecko.R
import com.example.coingecko.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Boolean

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.categoriesFragment, R.id.exchangeFragment, R.id.coinsFragment)
        )
        val navView: BottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

        override fun onSupportNavigateUp(): kotlin.Boolean {
            val navController = findNavController(R.id.nav_host_fragment_activity_main)
            return navController.navigateUp() || super.onSupportNavigateUp()
        }



}