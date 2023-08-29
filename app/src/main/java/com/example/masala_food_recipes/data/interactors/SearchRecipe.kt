package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class SearchRecipe(private val recipes: List<Recipe>) {
    fun execute() =
        recipes
            .map { recipe ->
                listOf(
                    recipe.translatedRecipeName,
                    recipe.totalTimeInMins,
                    recipe.imageUrl
                )
            }
}
