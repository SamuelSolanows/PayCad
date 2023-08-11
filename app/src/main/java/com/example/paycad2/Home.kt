package com.example.paycad2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.paycad2.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var name = intent.getStringExtra("nombre")

        binding.apply {
            txtnamehome.text = name
        }
    }
}