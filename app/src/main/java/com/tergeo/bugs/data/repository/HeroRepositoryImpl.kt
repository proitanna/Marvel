package com.tergeo.bugs.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tergeo.bugs.domain.repository.HeroRepository
import com.tergeo.bugs.domain.entity.HeroModel
import com.tergeo.bugs.data.service.API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroRepositoryImpl constructor(private val retrofitService: API) : HeroRepository {

    companion object {
        private const val TAG = "HeroRepository"
    }

    override fun getHeroList(): LiveData<List<HeroModel>> {
        val liveData = MutableLiveData<List<HeroModel>>()
        retrofitService.getHeroList().enqueue(object : Callback<List<HeroModel>> {
            override fun onResponse(
                call: Call<List<HeroModel>>,
                response: Response<List<HeroModel>>,
            ) {
                if (response.isSuccessful && response.body() != null) {
                    liveData.postValue(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<HeroModel>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })

        return liveData
    }
}