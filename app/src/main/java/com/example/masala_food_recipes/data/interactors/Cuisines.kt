package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class Cuisines(private val recipes : List<Recipe>)
{
    fun getCuisineCards() =
            recipes
                    .groupBy { it.cuisine }
                    .map {
                        listOf(
                                it.value.size ,
                                it.value[it.value.size].imageUrl
                        )
                    }
}