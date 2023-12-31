package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class UnderTwentyMinRecipe(private val recipes: List<Recipe>) {
    fun execute() =
        recipes
            .filter { it.totalTimeInMins.toInt() < 20 }
            .shuffled()
            .map {
                listOf(
                    it.translatedRecipeName,
                    it.totalTimeInMins,
                    it.imageUrl
                )
            }
}