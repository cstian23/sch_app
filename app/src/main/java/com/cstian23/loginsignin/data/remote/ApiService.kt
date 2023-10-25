package com.cstian23.loginsignin.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("exercise-api")
    fun getUsers(): Call<List<ExercisesItem>>
}