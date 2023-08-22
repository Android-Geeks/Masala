package com.example.masala_food_recipes.data.listener

import com.example.masala_food_recipes.data.entities.Recipe

interface Under20MinFragmentListener {
    fun onPass(
            allRecipes : List<Recipe> , under20MinList : List<List<String>>
    )
}