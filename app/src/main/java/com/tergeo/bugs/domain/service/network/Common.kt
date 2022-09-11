package com.tergeo.bugs.domain.service.network

import com.tergeo.bugs.infrastructure.sevice.RetrofitClient

object Common {
    private const val BASE_URL = "https://www.simplifiedcoding.net/demos/"

    val retrofitService: API = RetrofitClient.getClient(BASE_URL).create(API::class.java)
}