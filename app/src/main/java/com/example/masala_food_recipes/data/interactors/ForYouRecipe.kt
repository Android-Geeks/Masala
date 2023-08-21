package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class ForYouRecipe(private val recipes: List<Recipe>) {
    fun execute(limit: Int) =
        recipes
            .shuffled()
            .take(limit)
            .map { recipe ->
                listOf(
                    recipe.translatedRecipeName,
                    recipe.cuisine,
                    recipe.imageUrl
                )
            }
}
