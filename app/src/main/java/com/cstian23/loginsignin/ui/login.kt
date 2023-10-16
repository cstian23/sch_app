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
import com.cstian23.loginsignin.sqlite.UserRepository
import android.widget.Toast

class login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            val userRepository = UserRepository(this)
            val user = userRepository.getUser(email)

            val username = user?.username

            if (user != null && user.password == password) {
                val intent = Intent(this, Home::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }
    }
}