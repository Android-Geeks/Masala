package com.example.masala_food_recipes.ui.recycler_view

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.ViewTarget
import com.bumptech.glide.request.transition.Transition
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.ForYouRecipe
import com.example.masala_food_recipes.databinding.RecipeCardBinding
import com.example.masala_food_recipes.ui.recyclerview.BaseRecyclerAdapter

class ForYouRecipeAdapter(items: List<Recipe>) :BaseRecyclerAdapter<Recipe,BaseRecyclerAdapter.BaseViewHolder<Recipe>>(items) {
    override val layoutId = R.layout.recipe_card

    override fun createViewHolder(view: View): BaseViewHolder<Recipe> =RecipeViewHolder(view)

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
