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
    fun doNothing() {
        // Empty implementation
    }
}

class CuisineAdapter(items: List<Recipe>, listener: CuisineListener) :BaseRecyclerAdapter<Recipe,BaseRecyclerAdapter.BaseViewHolder<Recipe>>(items, listener) {
    override val layoutId = R.layout.card_view_cuisines

    override fun createViewHolder(view: View): BaseViewHolder<Recipe> = CuisineViewHolder(view)

    class CuisineViewHolder(itemView: View) : BaseViewHolder<Recipe>(itemView) {
        private val binding = CardViewCuisinesBinding.bind(itemView)
        private val context: Context = itemView.context

        @SuppressLint("SetTextI18n")
        override fun bind(item: Recipe) {
            val cuisineMap = Cuisines(listOf(item)).getCuisineCards()
                val key = cuisineMap.keys.joinToString(",")
                binding.apply {
                    cuisineTextview.text = key
                    itemsCount.text = "${Cuisines(DataManager(context).getAllRecipesData()).getCuisineCards()[key]!!.first.toString()} item"


                    Glide.with(context)
                        .load(Cuisines(listOf(item)).getCuisineCards().values.first().second)
                        .centerCrop()
                        .into(foodImage)
                }
        }
    }
}