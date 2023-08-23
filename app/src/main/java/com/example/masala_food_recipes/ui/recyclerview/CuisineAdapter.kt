package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.databinding.CardViewCuisinesBinding

interface CuisineListener :BaseInteractionListener

class CuisineAdapter(items: List<List<String>>, listener: CuisineListener) :BaseRecyclerAdapter<List<String>,BaseRecyclerAdapter.BaseViewHolder<List<String>>>(items, listener) {
    override val layoutId = R.layout.card_view_cuisines

    override fun createViewHolder(view: View): BaseViewHolder<List<String>> = CuisineViewHolder(view)

    class CuisineViewHolder(itemView: View) : BaseViewHolder<List<String>>(itemView) {
        private val binding = CardViewCuisinesBinding.bind(itemView)
        private val context: Context = itemView.context
        @SuppressLint("SetTextI18n")
        override fun bind(item: List<String>) {
            binding.apply {
                cuisineTextview.text = item[0]
                itemsCount.text = "${item[1]} item"


                Glide.with(context)
                    .load(item[2])
                    .centerCrop()
                    .placeholder(R.drawable.loading)
                    .into(foodImage)
            }
        }
    }
}