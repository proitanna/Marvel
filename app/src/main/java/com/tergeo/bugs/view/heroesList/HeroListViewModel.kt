package com.tergeo.bugs.view.heroesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tergeo.bugs.domain.entity.HeroModel

class HeroListViewModel constructor(
    private val interactor: HeroListInteractor
): ViewModel() {

    companion object {
        private const val TAG = "HeroViewModel"
    }

    var heroListLiveData: LiveData<List<HeroModel>> = MutableLiveData()
    val errorMessage = MutableLiveData<String>()

    fun getHeroList() {
        heroListLiveData = interactor.getHeroes()
    }
}