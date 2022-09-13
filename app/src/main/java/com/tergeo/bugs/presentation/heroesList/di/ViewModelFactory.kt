package com.tergeo.bugs.presentation.heroesList.di

import HeroListInteractorImpl
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tergeo.bugs.domain.repository.HeroRepository
import com.tergeo.bugs.presentation.heroesList.HeroListViewModel

class ViewModelFactory(
    private val repository: HeroRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HeroListViewModel::class.java)) {
            HeroListViewModel(
                HeroListInteractorImpl(
                    this.repository
                )
            ) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
