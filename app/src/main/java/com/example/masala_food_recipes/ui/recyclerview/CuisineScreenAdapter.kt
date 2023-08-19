package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.databinding.CuisineScreenCardBinding

interface CuisineScreenListener : BaseInteractionListener

class CuisineScreenAdapter(items: List<Recipe>, listener: CuisineScreenListener) :BaseRecyclerAdapter<Recipe,BaseRecyclerAdapter.BaseViewHolder<Recipe>>(items, listener) {
    override val layoutId = R.layout.cuisine_screen_card

    override fun createViewHolder(view: View): BaseViewHolder<Recipe> = CuisineViewHolder(view)

    class CuisineViewHolder(itemView: View) : BaseViewHolder<Recipe>(itemView) {
        private val binding = CuisineScreenCardBinding.bind(itemView)
        private val context: Context = itemView.context
        private val allCuisines = Cuisines(DataManager(context).getAllRecipesData()).getCuisineCards()
        //item consist of only one recipe(Cuisine) not list of recipes so we need to get all cuisines to count The number of repetitions
        @SuppressLint("SetTextI18n")
        override fun bind(item: Recipe) {
            val cuisineMap = Cuisines(listOf(item)).getCuisineCards()
            val key = cuisineMap.keys.joinToString(",")
            binding.apply {
                textViewCuisines.text= key
                textViewNumberOfItems.text ="${allCuisines[key]?.first.toString()} item"

                Glide.with(context)
                    .load(cuisineMap.values.first().second)
                    .centerCrop()
                    .into(imageview)
            }
        }
    }
}
