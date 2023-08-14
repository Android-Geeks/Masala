package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class UnderTwentyMinsRecipe(private val recipes : List<Recipe>) {
    fun execute() =
            recipes
                    .filter { it.totalTimeInMins.toInt() < 20 }
                    .shuffled()
                    .map { recipe ->
                        listOf(
                            recipe.translatedRecipeName ,
                            recipe.totalTimeInMins ,
                            recipe.imageUrl
                        )
                    }
}