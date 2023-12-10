package com.cstian23.loginsignin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cstian23.loginsignin.R
import com.cstian23.loginsignin.data.MainAdapter
import com.cstian23.loginsignin.data.remote.ApiService
import com.cstian23.loginsignin.data.remote.ExercisesItem
import com.cstian23.loginsignin.databinding.ActivityLowerBodyBinding
import com.cstian23.loginsignin.util.constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LowerBodyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLowerBodyBinding
    private lateinit var viewAdapter: MainAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLowerBodyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewManager = LinearLayoutManager(this)
        getUsersData()
    }

    private fun getUsersData() {
        var retrofit = Retrofit.Builder()
            .baseUrl(constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        retrofit.getUsers().enqueue(object : retrofit2.Callback<List<ExercisesItem>> {
            override fun onResponse(
                call: retrofit2.Call<List<ExercisesItem>>,
                response: retrofit2.Response<List<ExercisesItem>>
            ){
                if (response.isSuccessful){
                    val data = response.body()!!
                    viewAdapter = MainAdapter(baseContext, data)
                    binding.itemRv.apply {
                        layoutManager = viewManager
                        adapter = viewAdapter
                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<List<ExercisesItem>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}