package com.example.easyinvest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.easyinvest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            val navController = findNavController(R.id.fragmentContainerView)
            when (item.itemId) {
                R.id.navigation_portfolio -> {
                    navController.navigate(R.id.fragmentPortfolio)
                    true
                }

                R.id.navigation_asset -> {
                    navController.navigate(R.id.fragmentAsset)
                    true
                }

                R.id.navigation_settings -> {
                    navController.navigate(R.id.fragmentSettings)
                    true
                }

                else -> false
            }
        }
    }
}
