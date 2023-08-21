package com.example.masala_food_recipes.data.util
import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.example.masala_food_recipes.MainActivity
import com.example.masala_food_recipes.data.entities.Recipe
object MyViewModle : ViewModel() {
    var under20MinList : List<List<String>> = emptyList()
    var under5IngredientList : List<List<String>> = emptyList()
    var allRecipes : List<Recipe> = emptyList()
    var forYouList : List<List<String>> = emptyList()
    var cuisineList : List<List<String>> = emptyList()
    @SuppressLint("StaticFieldLeak")
    var mainActivity : MainActivity? = null
}