package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe

/*class UnderFiveIngredient(private val recipes: List<Recipe>) {
    fun execute(limit: Int) =
        recipes
            .filter { it.ingredientCount.toInt() < 5 }
            .take(limit)
            .shuffled()
            .associate { (Pair(it.translatedRecipeName, Pair(it.totalTimeInMins, it.imageUrl))) }
}*/

class UnderFiveIngredient(private val recipes : List<Recipe>) {
    fun execute() =
            recipes
                    .filter { it.ingredientCount.toInt() < 5 }
                    .shuffled()
                    .map { recipe ->
                        listOf(
                            recipe.translatedRecipeName ,
                            recipe.totalTimeInMins ,
                            recipe.imageUrl
                        )
                    }
}