package com.example.masala_food_recipes.data

import android.content.Context
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.util.CsvParser
import com.example.masala_food_recipes.data.entities.Recipe
import java.io.BufferedReader
import java.io.InputStreamReader

class DataManager(private val context: Context) {

    private var allRecipes: List<Recipe>? = null

    fun getAllRecipesData(): List<Recipe> {
        if (allRecipes == null)
            allRecipes = CsvParser(getCsvData()).constructAllRecipes()
        return allRecipes!!
    }

    private fun getCsvData(): BufferedReader {
        val inputStream = context.resources.openRawResource(R.raw.indian_food_v3)
        return BufferedReader(InputStreamReader(inputStream))
    }

}