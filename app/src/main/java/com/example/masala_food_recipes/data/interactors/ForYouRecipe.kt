package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class ForYouRecipe(private val recipes: List<Recipe>) {
    fun execute() =
        recipes
            .shuffled()
            .map { recipe ->
                listOf(
                    recipe.translatedRecipeName,
                    recipe.cuisine,
                    recipe.imageUrl
                )
            }
}
