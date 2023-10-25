package com.cstian23.loginsignin.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.cstian23.loginsignin.R
import com.cstian23.loginsignin.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    companion object {
        val IMAGE_REQUEST_CODE = 100
    }

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username")

        if (username != null) {
            binding.username.text = "$username!"
        }

        binding.pfp.setOnClickListener {
            pickImageGalery()
        }

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

        binding.spotify.setOnClickListener {
            val link = "https://spotify.com/"
            openSocialMedia(link)
        }

        binding.ig.setOnClickListener {
            val link = "https://instagram.com/"
            openSocialMedia(link)
        }

        binding.twitter.setOnClickListener {
            val link = "https://twitter.com/"
            openSocialMedia(link)
        }

        binding.tt.setOnClickListener {
            val link = "https://tiktok.com/"
            openSocialMedia(link)
        }

        binding.yt.setOnClickListener {
            val link = "https://youtube.com/"
            openSocialMedia(link)
        }
    }

    private fun pickImageGalery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    private fun openSocialMedia(link: String) {
        val uri = Uri.parse(link)
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            val url = data?.data

            Glide.with(this)
                .load(url)
                .fitCenter()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.default_pfp)
                .into(binding.pfp)
        }
    }
}