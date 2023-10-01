package com.cstian23.loginsignin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cstian23.loginsignin.R
import com.cstian23.loginsignin.ui.Home
import com.cstian23.loginsignin.ui.register
import com.cstian23.loginsignin.databinding.ActivitySplashBinding
import com.cstian23.loginsignin.MainActivity
import com.cstian23.loginsignin.databinding.ActivityLoginBinding
import com.cstian23.loginsignin.databinding.ActivityMainBinding

class login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }
    }
}