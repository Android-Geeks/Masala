package com.example.masala_food_recipes.ui


interface FavouritesInteractionListener {
    fun onEmptyFavourite()
    fun onRecipeClicked(recipe: List<String>)
}