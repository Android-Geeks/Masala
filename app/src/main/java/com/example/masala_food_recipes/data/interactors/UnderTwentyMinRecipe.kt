package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class UnderTwentyMinRecipe(private val recipes : List<Recipe>)
{
    fun execute() =
            recipes
                    .filter { it.totalTimeInMin.toInt() < 20 }
                    .shuffled()
                    .map {
                        listOf(
                                it.translatedRecipeName ,
                                it.totalTimeInMin ,
                                it.imageUrl
                        )
                    }
}