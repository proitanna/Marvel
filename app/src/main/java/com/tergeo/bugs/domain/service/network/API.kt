package com.tergeo.bugs.domain.service.network

import com.tergeo.bugs.domain.entity.HeroModel
import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("marvel")
    fun getHeroList(): Call<List<HeroModel>>
}