package com.example.masala_food_recipes.data.util

import android.content.Context
import android.content.SharedPreferences

object FavouritePreferences {
    private lateinit var sharedPref : SharedPreferences
    private const val FAVOURITE_SHARED_KEY = "FAVOURITE_PREFS"
    private const val FAVOURITE_SET_KEY = "FAVOURITE_SET"

    fun init(context : Context) {
        sharedPref = context.getSharedPreferences(FAVOURITE_SHARED_KEY , Context.MODE_PRIVATE)
    }

    fun getFromSharedPref() =
            sharedPref.getStringSet(FAVOURITE_SET_KEY , emptySet())?.toMutableSet()

    fun putInSharedPref(value : Set<String>) =
            sharedPref.edit()?.putStringSet(FAVOURITE_SET_KEY , value)?.apply()
}