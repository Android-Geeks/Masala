package com.example.masala_food_recipes.data.listener

import com.example.masala_food_recipes.data.entities.Recipe

interface HomeFragmentListener {
    fun onPass(
            allRecipes : List<Recipe> ,
            cuisineList : List<List<String>> ,
            forYouList : List<List<String>> ,
            under20MinList : List<List<String>> ,
            under5IngredientList : List<List<String>>
    )
}