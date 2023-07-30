package com.example.masala_food_recipes.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class RecipeTime (private val recipes : List<Recipe> ) {

    fun underTwentyMin(): List<Recipe>{
        val list = mutableListOf<Recipe>()
        recipes.forEach{
            if (it.totalTimeInMins.toInt() < 20){
                list.add(it)
            }
        }
        return list.shuffled()
    }
}