package com.tergeo.bugs.heroinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.tergeo.bugs.R
import com.tergeo.bugs.herolist.model.HeroModel


class HeroInfoFragment : Fragment() {

    companion object {

        private const val HERO_ARG = "hero"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_hero_info, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = view.findViewById<TextView>(R.id.nameText)
        val realName = view.findViewById<TextView>(R.id.realNameText)
        val team = view.findViewById<TextView>(R.id.teamText)
        val bio = view.findViewById<TextView>(R.id.bioText)
        val image = view.findViewById<ImageView>(R.id.heroImage)

        val model: HeroModel = requireArguments().getSerializable("hero") as HeroModel

        name.text = model.name
        realName.text = model.realName
        team.text = model.team
        bio.text = model.bio
        Glide.with(requireContext())
            .load(model.imageUrl)
            .into(image)
    }
}