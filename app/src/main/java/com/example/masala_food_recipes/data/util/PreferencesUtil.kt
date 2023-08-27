package com.example.masala_food_recipes.data.util

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
        sharedPref.edit()?.putString(key, value)?.apply()
    }
}