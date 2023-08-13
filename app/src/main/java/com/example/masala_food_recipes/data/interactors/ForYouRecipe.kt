package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class ForYouRecipe(private val recipes: List<Recipe>) {
    fun execute(limit: Int) =
        recipes
            .asSequence()
            .shuffled()
            .take(limit)
            .associate { (Pair(it.translatedRecipeName,Pair(it.cuisine, it.imageUrl))) }
}
