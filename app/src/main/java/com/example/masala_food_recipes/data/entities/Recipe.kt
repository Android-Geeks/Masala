package com.example.masala_food_recipes.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val translatedRecipeName: String,
    val translatedIngredients: List<String>,
    val totalTimeInMins: String,
    val cuisine: String,
    val translatedInstructions: List<String>,
    val url: String,
    val cleanedIngredients: List<String>,
    val imageUrl: String,
    val ingredientCount: String,
) : Parcelable