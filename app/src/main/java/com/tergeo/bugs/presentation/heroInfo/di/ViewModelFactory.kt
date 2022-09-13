package com.tergeo.bugs.presentation.heroInfo.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tergeo.bugs.presentation.heroInfo.HeroInfoViewModel
import com.tergeo.bugs.presentation.heroesList.HeroListViewModel

class ViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HeroListViewModel::class.java)) {
            HeroInfoViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
