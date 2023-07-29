package com.example.masala_food_recipes


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.data.interactors.ForYouRecipe

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cuisine Card Info
        Cuisines(DataManager(this).getAllRecipesData()).getCuisineCards().forEach {
            Log.d("Cuisine", "Cuisine: ${it.key} has ${it.value.first} recipes and the image url is ${it.value.second}")
        }

        // For You List
        ForYouRecipe(DataManager(this).getAllRecipesData()).execute(20).forEach {
            Log.d("For You", "Recipe Name is ${it.key} and the cuisine is ${it.value.first} and the image url is ${it.value.second}")
        }

    }
}

//test