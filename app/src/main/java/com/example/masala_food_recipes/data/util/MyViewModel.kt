package com.example.masala_food_recipes.data.util
import androidx.lifecycle.ViewModel
import com.example.masala_food_recipes.data.entities.Recipe
object MyViewModle : ViewModel() {
    var under20MinList : List<List<String>> = emptyList()
    var under5IngredientList : List<List<String>> = emptyList()
    var allRecipes : List<Recipe> = emptyList()
    var forYouList : List<List<String>> = emptyList()
    var cuisineList : List<List<Any>> = emptyList()
}