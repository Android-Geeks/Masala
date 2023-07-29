package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe

class Recipe (recipes:List<Recipe>){

    val forYouList = recipes
                        .asSequence()
                        .shuffled()
                        .take(20)
                        .associate { (Pair(it.translatedRecipeName,it.cuisine)) }
}