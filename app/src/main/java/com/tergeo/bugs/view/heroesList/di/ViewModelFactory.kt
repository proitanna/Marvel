package com.tergeo.bugs.view.heroesList.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tergeo.bugs.domain.repository.HeroRepository
import com.tergeo.bugs.view.heroesList.HeroListInteractorImpl
import com.tergeo.bugs.view.heroesList.HeroListViewModel

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
