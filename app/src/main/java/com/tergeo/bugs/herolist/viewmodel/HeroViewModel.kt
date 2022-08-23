package com.tergeo.bugs.herolist.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tergeo.bugs.herolist.model.HeroModel
import com.tergeo.bugs.network.Common
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroViewModel constructor(private val repository: MainRepository): ViewModel() {

    companion object {
        private const val TAG = "HeroViewModel"
    }

    val heroListLiveData = MutableLiveData<List<HeroModel>>()
    val errorMessage = MutableLiveData<String>()

    fun getHeroList() {
        val response = repository.getHeroList()
        response.enqueue(object: Callback<List<HeroModel>>{

            override fun onResponse(
                call: Call<List<HeroModel>>,
                response: Response<List<HeroModel>>
            ) {

                if (response.isSuccessful && response.body() != null) {
                   heroListLiveData.postValue(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<HeroModel>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })
    }
}