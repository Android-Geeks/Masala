package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class UnderTwentyMinsRecipe(private val recipes: List<Recipe>) {
    fun execute(limit: Int) =
        recipes
            .filter { it.totalTimeInMins.toInt() < 20 }
            .take(limit)
            .shuffled()
            .associate { (Pair(it.translatedRecipeName, Pair(it.totalTimeInMins, it.imageUrl))) }
}
/*class UnderTwentyMinsRecipe(private val recipes : List<Recipe>) {
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
}*/