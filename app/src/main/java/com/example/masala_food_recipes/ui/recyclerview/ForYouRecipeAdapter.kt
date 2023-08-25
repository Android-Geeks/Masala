package com.example.masala_food_recipes.ui.recyclerview

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.Details
import com.example.masala_food_recipes.databinding.RecipeCardBinding
import com.example.masala_food_recipes.ui.fragment.HomeFragmentDirections

interface ForYouRecipeListener : BaseInteractionListener
class ForYouRecipeAdapter(
        items : List<List<String>> ,
        listener : ForYouRecipeListener ,
        val sharedPref : SharedPreferences ,
        val allRecipes : List<Recipe>
) : BaseRecyclerAdapter<List<String> , BaseRecyclerAdapter.BaseViewHolder<List<String>>>(
        items , listener) {
    override val layoutId = R.layout.recipe_card
    val favouriteSet = sharedPref.getStringSet("Favourite" , emptySet())?.toMutableSet()

    override fun createViewHolder(view : View) : BaseViewHolder<List<String>> =
            RecipeViewHolder(view)

    inner class RecipeViewHolder(itemView : View) : BaseViewHolder<List<String>>(itemView) {

        private val binding = RecipeCardBinding.bind(itemView)
        private val context : Context = itemView.context
        override fun bind(item : List<String>) {
            binding.apply {
                recipeName.text = item[0]
                recipeCuisine.text = item[1]
                Glide.with(context).load(item[2]).placeholder(R.drawable.loading).centerCrop()
                        .into(recipeImage)
                checkBox.apply {
                    setOnCheckedChangeListener { _ , isChecked ->
                        if (isChecked) favouriteSet?.add(item[0])
                        else favouriteSet?.remove(item[0])
                        sharedPref.edit().putStringSet("Favourite" , favouriteSet).apply()
                    }
                    isChecked = favouriteSet?.contains(item[0]) == true
                }
                recipeImage.setOnClickListener {

                    val action = HomeFragmentDirections.actionHomeFragmentToFragmentDetailsScreen(
                            Details(allRecipes).findRecipe(item[0]))
                    Navigation.findNavController(it).navigate(action)
                }

            }
        }

    }
}