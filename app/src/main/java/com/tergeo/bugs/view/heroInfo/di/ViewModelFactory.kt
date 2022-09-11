package com.tergeo.bugs.view.heroInfo.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tergeo.bugs.view.heroInfo.HeroInfoViewModel
import com.tergeo.bugs.view.heroesList.HeroListViewModel

class ViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HeroListViewModel::class.java)) {
            HeroInfoViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
