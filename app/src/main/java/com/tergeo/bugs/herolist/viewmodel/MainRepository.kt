package com.tergeo.bugs.herolist.viewmodel

import com.tergeo.bugs.network.API
import retrofit2.Retrofit

class MainRepository constructor(private val retrofitService: API) {
    fun getHeroList() = retrofitService.getHeroList()
}