package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class Details(private val recipes: List<Recipe>) {
    fun findRecipe(name: String): Recipe =
        recipes.find { it.translatedRecipeName == name }!!
}