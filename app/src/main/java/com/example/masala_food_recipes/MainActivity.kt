package com.example.masala_food_recipes

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.databinding.ActivityMainBinding
import com.example.masala_food_recipes.ui.recycler_view.CuisineAdapter
import com.example.masala_food_recipes.ui.recycler_view.ForYouRecipeAdapter
import com.example.masala_food_recipes.ui.recycler_view.UnderFiveIngredientAdapter
import com.example.masala_food_recipes.ui.recycler_view.UnderTwentyMinAdapter


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipeList = DataManager(this).getAllRecipesData()

        binding.cuisineRecycler.adapter = CuisineAdapter(recipeList)

        binding.recipeRecycler.adapter = ForYouRecipeAdapter(recipeList)

        binding.underFiveRecycler.adapter = UnderFiveIngredientAdapter(recipeList)
        binding.underTwentyRecycler.adapter = UnderTwentyMinAdapter(recipeList)





    }
}