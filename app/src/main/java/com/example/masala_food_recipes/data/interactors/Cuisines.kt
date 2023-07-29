package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe
import kotlin.random.Random.Default.nextInt

class Cuisines(private val recipes: List<Recipe>) {
    fun getCuisineCards(): Map<String, Pair<Int, String>> =
        recipes
            .groupBy { it.cuisine }
            .mapValues {
                Pair(
                    it.value.size,
                    it.value[nextInt(it.value.size)].imageUrl
                )
            }

}