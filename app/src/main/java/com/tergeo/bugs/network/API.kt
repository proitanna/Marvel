package com.tergeo.bugs.network

import com.tergeo.bugs.herolist.model.HeroModel
import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("marvel")
    fun getHeroList(): Call<List<HeroModel>>
}