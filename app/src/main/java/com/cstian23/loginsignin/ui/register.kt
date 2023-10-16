package com.cstian23.loginsignin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cstian23.loginsignin.R
import com.cstian23.loginsignin.databinding.ActivityRegisterBinding
import com.cstian23.loginsignin.databinding.ActivitySplashBinding
import com.cstian23.loginsignin.models.User
import com.cstian23.loginsignin.sqlite.UserRepository

class register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            val user = User(0, username, email, password)

            val userRepository = UserRepository(this)
            val userId = userRepository.addUser(user)

            if (userId != -1L) {
                binding.etUsername.text?.clear()
                binding.etEmail.text?.clear()
                binding.etPassword.text?.clear()
                Toast.makeText(this, "Registrasi sukses, silakan login", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, login::class.java)
                startActivity(intent)
            } else {
                binding.etUsername.text?.clear()
                binding.etEmail.text?.clear()
                binding.etPassword.text?.clear()
                Toast.makeText(this, "Registrasi gagal", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
    }
}