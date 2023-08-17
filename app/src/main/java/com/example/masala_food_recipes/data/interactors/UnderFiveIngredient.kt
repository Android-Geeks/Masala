package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class UnderFiveIngredient(private val recipes : List<Recipe>)
{
    fun execute() =
            recipes
                    .filter { it.ingredientCount.toInt() < 5 }
                    .shuffled()
                    .map {
                        listOf(
                                it.translatedRecipeName ,
                                it.totalTimeInMin ,
                                it.imageUrl
                        )
                    }
}