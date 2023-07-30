package com.example.masala_food_recipes.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class Ingredient (private val recipes: List<Recipe>){

    fun underFiveIngredient(): List<Recipe>{
        val list =  mutableListOf<Recipe>()
        recipes.forEach {
            if (it.ingredientCount.toInt() < 5){
                list.add(it)
            }
        }
        return list.shuffled()
    }
}