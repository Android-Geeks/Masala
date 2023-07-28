package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class Cuisine(private val recipes:List<Recipe>) {

    fun getCuisines():Map<String,Int>{
        val mapCuisine = mutableMapOf<String,Int>()
        recipes.forEach {
            mapCuisine.putIfAbsent(it.cuisine,0)
            mapCuisine[it.cuisine] = mapCuisine[it.cuisine]!! + 1
        }
        return mapCuisine
    }

    fun getRecipesName():Map<String,List<String>>{
        val mapRecipe= mutableMapOf<String,List<String>>()
        recipes.shuffled().forEach {
            mapRecipe[it.translatedRecipeName]?.plus(it.cuisine)
        }
        return mapRecipe
    }
}