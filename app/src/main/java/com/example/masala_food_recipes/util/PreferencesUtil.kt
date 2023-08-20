package com.example.masala_food_recipes.util

import android.content.Context
import android.content.SharedPreferences

object PreferencesUtil {
    lateinit var sharedPref : SharedPreferences
    private const val Shared_Preferences = "MySharedPref"

    fun init(context: Context){
        sharedPref = context.getSharedPreferences(Shared_Preferences, Context.MODE_PRIVATE)
    }
    fun getFromSharedPref(key : String):String?{
        return sharedPref.getString(key, null)
    }
    fun putInSharedPref(key: String, value :String) {
        val existingValue = listOf(sharedPref.getString(key, ""))
        val updatedValue = existingValue + value
        sharedPref.edit()?.putString(key, updatedValue.toString())?.apply()
//        sharedPref.edit()?.putString(key, value)?.apply()
    }
}