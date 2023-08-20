package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.databinding.CardViewSearchBinding

interface FavouriteListener : BaseInteractionListener

class FavouriteAdapter(items: List<List<String>>, listener: FavouriteListener) :BaseRecyclerAdapter<List<String>,BaseRecyclerAdapter.BaseViewHolder<List<String>>>(items, listener) {
    override val layoutId: Int = R.layout.card_view_search

    override fun createViewHolder(view: View): BaseViewHolder<List<String>> =
        FavouriteViewHolder(view)

    class FavouriteViewHolder(itemView: View) : BaseViewHolder<List<String>>(itemView) {
        private val binding = CardViewSearchBinding.bind(itemView)
        private val context: Context = itemView.context

        @SuppressLint("SetTextI18n")
        override fun bind(item: List<String>) {

            binding.apply {
                recipeText.text =  "${item[0]} min"
                minutesText.text = "${item[1]} min"
                Glide.with(context)
                    .load(item[2])
                    .centerCrop()
                    .into(itemImage)
            }

        }

    }
}
