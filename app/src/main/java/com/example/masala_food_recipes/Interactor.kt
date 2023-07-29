package com.example.masala_food_recipes

import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.entities.Recipe

class Interactor(context: MainActivity) {

    private val recipes = DataManager(context).getAllRecipesData()
    fun underTwentyMin(): List<Recipe>{
        val list = mutableListOf<Recipe>()
        recipes.forEach{
            if (it.totalTimeInMins.toInt() < 20){
                list.add(it)
            }
        }
        return list.shuffled()
    }

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