package com.tergeo.bugs.view.heroesList.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.tergeo.bugs.R
import com.tergeo.bugs.view.heroInfo.view.HeroInfoFragment
import com.tergeo.bugs.domain.entity.HeroModel
import com.tergeo.bugs.view.heroesList.HeroListViewModel
import com.tergeo.bugs.infrastructure.repository.HeroRepositoryImpl
import com.tergeo.bugs.view.heroesList.di.ViewModelFactory
import com.tergeo.bugs.domain.service.network.Common.retrofitService

class MarvelHeroListFragment : Fragment(), HeroAdapter.OnHeroClickListener {
    companion object {

        private const val HERO_ARG = "hero"
    }

    private val viewModel by lazy {
        ViewModelProvider(this, ViewModelFactory(HeroRepositoryImpl(retrofitService)))
            .get(HeroListViewModel::class.java)
    }
    private var adapter = HeroAdapter(this)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_marvel_hero_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.hero_recycler)
        recycler.adapter = adapter

        viewModel.apply {
            getHeroList()
            heroListLiveData.observe(viewLifecycleOwner, Observer{
                adapter.submitList(it)
            })
            errorMessage.observe(viewLifecycleOwner, Observer{
            })
        }
    }

    override fun onHeroClick(model: HeroModel) {
        val bundle = Bundle()
        bundle.putSerializable("hero", model)
        val fragment: Fragment = HeroInfoFragment()
        fragment.arguments = bundle
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_place, fragment)
            .addToBackStack(null)
            .commit()
    }
}