package com.tergeo.bugs.herolist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.tergeo.bugs.R
import com.tergeo.bugs.heroinfo.HeroInfoFragment
import com.tergeo.bugs.herolist.model.HeroModel
import com.tergeo.bugs.herolist.viewmodel.HeroViewModel
import com.tergeo.bugs.herolist.viewmodel.MainRepository
import com.tergeo.bugs.herolist.viewmodel.ViewModelFactory
import com.tergeo.bugs.network.Common.retrofitService

class MarvelHeroList : Fragment(), HeroAdapter.OnHeroClickListener {
    companion object {

        private const val HERO_ARG = "hero"
    }

    private lateinit var viewModel: HeroViewModel
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
      viewModel = ViewModelProvider(this, ViewModelFactory(MainRepository(retrofitService))).get(HeroViewModel::class.java)

        viewModel.heroListLiveData.observe(viewLifecycleOwner, Observer{
            adapter.submitList(it)
        })
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer{
        })
        viewModel.getHeroList()
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