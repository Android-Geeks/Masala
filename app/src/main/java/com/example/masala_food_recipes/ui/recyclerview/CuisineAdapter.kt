package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.databinding.CuisineCardBinding

interface CuisineListener :BaseInteractionListener{
    fun doNothing() {
        // Empty implementation
    }
}

class CuisineAdapter(items: List<Recipe>, listener: CuisineListener) :BaseRecyclerAdapter<Recipe,BaseRecyclerAdapter.BaseViewHolder<Recipe>>(items, listener) {
    override val layoutId = R.layout.cuisine_card

    override fun createViewHolder(view: View): BaseViewHolder<Recipe> = CuisineViewHolder(view)

    class CuisineViewHolder(itemView: View) : BaseViewHolder<Recipe>(itemView) {
        private val binding = CuisineCardBinding.bind(itemView)
        private val context: Context = itemView.context

        @SuppressLint("SetTextI18n")
        override fun bind(item: Recipe) {
            val key = Cuisines(listOf(item)).getCuisineCards().keys.joinToString(",")
            binding.apply {
                cuisineName.text = key
                itemNumber.text =Cuisines(DataManager(context).getAllRecipesData()).getCuisineCards()[key]!!.first.toString()
                textItem.text = "item"


                Glide.with(context)
                    .load(Cuisines(listOf(item)).getCuisineCards().values.first().second)
                    .centerCrop()
                    .into(cuisineImage)
            }
        }
    }
}