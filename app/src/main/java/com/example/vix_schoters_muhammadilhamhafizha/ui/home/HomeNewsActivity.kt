package com.example.vix_schoters_muhammadilhamhafizha.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.vix_schoters_muhammadilhamhafizha.R
import com.example.vix_schoters_muhammadilhamhafizha.databinding.ActivityHomeNewsBinding

class HomeNewsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment)
        binding.navView.setupWithNavController(navController)
    }
}