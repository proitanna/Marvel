package com.tergeo.bugs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tergeo.bugs.herolist.view.MarvelHeroList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_place,MarvelHeroList())
            .commit()
    }
}