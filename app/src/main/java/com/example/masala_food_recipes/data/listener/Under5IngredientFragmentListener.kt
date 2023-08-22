package com.example.masala_food_recipes.data.listener

import com.example.masala_food_recipes.data.entities.Recipe

interface Under5IngredientFragmentListener {
    fun onPass(
            allRecipes : List<Recipe> , under5IngredientList: List<List<String>>
    )
}