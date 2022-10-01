package com.example.vix_schoters_muhammadilhamhafizha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.vix_schoters_muhammadilhamhafizha.databinding.ActivityMainBinding
import com.example.vix_schoters_muhammadilhamhafizha.ui.home.HomeNewsActivity
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed(
            {
                val intent = Intent(this, HomeNewsActivity::class.java)
                startActivity(intent)
                finish()
            },3000
        )
    }
}