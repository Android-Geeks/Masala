package com.example.masala_food_recipes

import androidx.lifecycle.ViewModel
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.data.interactors.ForYouRecipe
import com.example.masala_food_recipes.data.interactors.SearchRecipe
import com.example.masala_food_recipes.data.interactors.UnderFiveIngredient
import com.example.masala_food_recipes.data.interactors.UnderTwentyMinRecipe

class GlobalViewModel: ViewModel() {
    var recipes: List<Recipe> = listOf()

    val under20MinList by lazy { UnderTwentyMinRecipe(recipes).execute() }
    val under5IngredientList by lazy { UnderFiveIngredient(recipes).execute() }
    val cuisineList by lazy { Cuisines(recipes).getCuisineCards() }
    val forYouList by lazy { ForYouRecipe(recipes).execute() }
    val searchList by lazy { SearchRecipe(recipes).execute() }
}