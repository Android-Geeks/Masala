package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe
import kotlin.random.Random.Default.nextInt

class Cuisines(private val recipes : List<Recipe>) {
    fun getCuisineCards() : List<List<String>> =
        recipes
                .groupBy { it.cuisine }
                .map { entry ->
                    val (cuisine , recipes) = entry
                    listOf(cuisine , recipes.size.toString() , recipes[nextInt(recipes.size)].imageUrl)
                }
                .shuffled()
}
