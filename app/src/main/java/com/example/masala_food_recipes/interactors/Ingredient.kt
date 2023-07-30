package com.example.masala_food_recipes.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class Ingredient(private val recipes: List<Recipe>) {
    fun underFiveIngredient(limit: Int) =
        recipes
            .filter { it.ingredientCount.toInt() < 5 }
            .take(limit)
            .shuffled()
            .associate { (Pair(it.translatedRecipeName, Pair(it.totalTimeInMins, it.imageUrl))) }
}