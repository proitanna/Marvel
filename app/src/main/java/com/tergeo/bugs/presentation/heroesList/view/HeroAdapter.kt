package com.tergeo.bugs.presentation.heroesList.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tergeo.bugs.R
import com.tergeo.bugs.domain.entity.HeroModel


class HeroAdapter(
    private val listener: OnHeroClickListener,
) : RecyclerView.Adapter<HeroAdapter.HeroVH>() {

    private var items = arrayListOf<HeroModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroVH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return HeroVH(view)
    }

    override fun onBindViewHolder(holder: HeroVH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun submitList(newList: List<HeroModel>) {
        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }

    inner class HeroVH(private val view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.txt_name)
        private val team = view.findViewById<TextView>(R.id.txt_team)
        private val image = view.findViewById<ImageView>(R.id.image_movie)

        fun bind(model: HeroModel) {
            name.setOnClickListener {
                listener.onHeroClick(model)
            }

            name.text = model.name
            team.text = model.team


            Glide.with(itemView.context)
                .load(model.imageUrl)
                .into(image)

        }
    }

    interface OnHeroClickListener {
        fun onHeroClick(model: HeroModel)
    }
}