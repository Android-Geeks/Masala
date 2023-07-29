package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class Cuisine(private val recipes:List<Recipe>) {

    val cuisineRecipes = recipes.groupBy({ it.cuisine }, { it.translatedRecipeName })

    fun getCuisineRecipesNumber(): Map<String, Int> = cuisineRecipes.mapValues { it.value.size }
}