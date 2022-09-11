package com.tergeo.bugs.domain.repository

import androidx.lifecycle.LiveData
import com.tergeo.bugs.domain.entity.HeroModel

interface HeroRepository {
    fun getHeroList(): LiveData<List<HeroModel>>
}