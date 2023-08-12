package com.example.masala_food_recipes.ui.recyclerview

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.ForYouRecipe
import com.example.masala_food_recipes.databinding.RecipeCardBinding

class ForYouRecipeAdapter(items: List<Recipe>) :BaseRecyclerAdapter<Recipe,BaseRecyclerAdapter.BaseViewHolder<Recipe>>(items) {
    override val layoutId = R.layout.recipe_card

    override fun createViewHolder(view: View): BaseViewHolder<Recipe> = RecipeViewHolder(view)

    class RecipeViewHolder(itemView:View):BaseViewHolder<Recipe>(itemView){

        private val binding = RecipeCardBinding.bind(itemView)
        private val context: Context = itemView.context
        override fun bind(item: Recipe) {
            binding.apply {
                recipeName.text =ForYouRecipe(listOf(item)).execute(10).keys.joinToString(",")
                recipeCuisine.text = ForYouRecipe(listOf(item)).execute(10).values.first().first

                Glide.with(context)
                    .load(ForYouRecipe(listOf(item)).execute(10).values.first().second)
                    .centerCrop()
                    .into(recipeImage)

            }
        }

    }
}
