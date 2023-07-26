package com.example.masala_food_recipes


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.masala_food_recipes.data.DataManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DataManager(this).getAllRecipesData().last().apply {
            Log.d("MainActivity", "onCreate: $translatedRecipeName")
            Log.d("MainActivity", "onCreate: $translatedIngredients")
            Log.d("MainActivity", "onCreate: $totalTimeInMins")
            Log.d("MainActivity", "onCreate: $cuisine")
            Log.d("MainActivity", "onCreate: $translatedInstructions")
            Log.d("MainActivity", "onCreate: $url")
            Log.d("MainActivity", "onCreate: $cleanedIngredients")
            Log.d("MainActivity", "onCreate: $imageUrl")
            Log.d("MainActivity", "onCreate: $ingredientCount")
        }
    }
}

//PO