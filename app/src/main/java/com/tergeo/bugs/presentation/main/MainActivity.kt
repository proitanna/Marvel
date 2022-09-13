package com.tergeo.bugs.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tergeo.bugs.R
import com.tergeo.bugs.presentation.heroesList.view.MarvelHeroListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_place, MarvelHeroListFragment())
            .commit()
    }
}