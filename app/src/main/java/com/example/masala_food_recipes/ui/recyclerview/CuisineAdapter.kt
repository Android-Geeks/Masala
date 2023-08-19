package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.databinding.CardViewCuisinesBinding

interface CuisineListener :BaseInteractionListener{
//    fun doNothing() {
//        // Empty implementation
//    }
}

class CuisineAdapter(items: List<List<String>>, listener: CuisineListener) :BaseRecyclerAdapter<List<String>,BaseRecyclerAdapter.BaseViewHolder<List<String>>>(items, listener) {
    override val layoutId = R.layout.card_view_cuisines

    override fun createViewHolder(view: View): BaseViewHolder<List<String>> = CuisineViewHolder(view)

    class CuisineViewHolder(itemView: View) : BaseViewHolder<List<String>>(itemView) {
        private val binding = CardViewCuisinesBinding.bind(itemView)
        private val context: Context = itemView.context
        private val allCuisines = Cuisines(DataManager(context).getAllRecipesData()).getCuisineCards()
        //item consist of only one recipe(Cuisine) not list of recipes so we need to get all cuisines to count The number of repetitions
        @SuppressLint("SetTextI18n")
        override fun bind(item: List<String>) {
//            val cuisineMap = Cuisines(listOf(item)).getCuisineCards()
//            val key = cuisineMap.keys.joinToString(",")
            binding.apply {
                cuisineTextview.text = item[0]
                itemsCount.text = "${item[1]} item"


                Glide.with(context)
                    .load(item[2])
                    .centerCrop()
                    .into(foodImage)
            }
        }
    }
}