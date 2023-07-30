package com.example.masala_food_recipes.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class RecipeTime(private val recipes: List<Recipe>) {

    fun underTwentyMin(limit: Int) =
        recipes
            .filter { it.totalTimeInMins.toInt() < 20 }
            .take(limit)
            .shuffled()
            .associate { (Pair(it.translatedRecipeName, Pair(it.totalTimeInMins, it.imageUrl))) }
}