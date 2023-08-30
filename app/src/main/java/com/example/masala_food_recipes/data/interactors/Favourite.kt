package com.example.masala_food_recipes.data.interactors

import com.example.masala_food_recipes.GlobalViewModel
import com.example.masala_food_recipes.data.util.FavouritePreferences

object Favourite {

    private val favList
        get() = FavouritePreferences.getFromSharedPref()?.toMutableSet()
    val recipes = GlobalViewModel.recipes

    fun getFavouriteList() = recipes.filter { favList?.contains(it.translatedRecipeName) !! }.map {
        listOf(
                it.translatedRecipeName , it.totalTimeInMins , it.imageUrl)
    }
}