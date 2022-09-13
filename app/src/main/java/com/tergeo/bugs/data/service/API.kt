package com.tergeo.bugs.data.service

import com.tergeo.bugs.domain.entity.HeroModel
import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("marvel")
    fun getHeroList(): Call<List<HeroModel>>
}