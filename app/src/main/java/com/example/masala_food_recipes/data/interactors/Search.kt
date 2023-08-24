package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.data.entities.Recipe
import java.util.Locale

class Search(private val recipes: List<Recipe>) {
    fun searchRecipe(keyword: String): List<Recipe> {
        val lowerCaseKeyword = keyword.lowercase(Locale.ROOT)
        return recipes.filter { it ->
            it.translatedRecipeName.lowercase(Locale.ROOT).contains(lowerCaseKeyword) ||
                    it.cuisine.contains(lowerCaseKeyword) ||
                    it.translatedIngredients.any {
                        it.lowercase(Locale.ROOT).contains(lowerCaseKeyword)
                    } ||
                    it.totalTimeInMins.contains(lowerCaseKeyword) ||

                    it.translatedInstructions.any {
                        it.lowercase(Locale.ROOT).contains(lowerCaseKeyword)
                    }
        }
    }
}