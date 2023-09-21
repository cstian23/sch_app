package com.cstian23.loginsignin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cstian23.loginsignin.R
import com.cstian23.loginsignin.ui.Home
import com.cstian23.loginsignin.ui.register
import com.cstian23.loginsignin.databinding.ActivitySplashBinding
import com.cstian23.loginsignin.MainActivity

class login : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn_login_1.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        binding.btn_login_2.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }
    }
}