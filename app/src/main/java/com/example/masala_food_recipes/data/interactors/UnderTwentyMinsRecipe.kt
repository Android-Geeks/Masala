package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class UnderTwentyMinsRecipe(private val recipes: List<Recipe>) {
    fun execute(limit: Int): List<Pair<String, Pair<String, String>>> =
        recipes
//            .filter { it.totalTimeInMins.toInt() < 20 }
            .take(limit)
            .shuffled()
            .map { recipe -> Pair(recipe.translatedRecipeName, Pair(recipe.totalTimeInMins, recipe.imageUrl)) }
}

