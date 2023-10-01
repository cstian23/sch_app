package com.cstian23.loginsignin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cstian23.loginsignin.R
import com.cstian23.loginsignin.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.upperBody.setOnClickListener {
            val intent = Intent(this, UpperBodyActivity::class.java)
            startActivity(intent)
        }

        binding.loseFat.setOnClickListener {
            val intent = Intent(this, LoseFatActivity::class.java)
            startActivity(intent)
        }

        binding.lowerBody.setOnClickListener {
            val intent = Intent(this, LowerBodyActivity::class.java)
            startActivity(intent)
        }
    }
}