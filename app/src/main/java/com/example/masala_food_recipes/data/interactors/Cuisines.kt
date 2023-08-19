package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe
import kotlin.random.Random

class Cuisines(private val recipes : List<Recipe>)
{
    fun getCuisineCards() =
            recipes
                    .groupBy { it.cuisine }
                    .map {
                        listOf(
                                it.value.size ,
                                it.value[Random.nextInt(it.value.size)].imageUrl
                        )
                    }
}