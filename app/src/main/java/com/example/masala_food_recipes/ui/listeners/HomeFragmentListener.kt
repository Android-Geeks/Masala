package com.example.masala_food_recipes.ui.listeners

interface HomeFragmentListener {
    fun onPass(
        cuisineList: List<List<String>>,
        forYouList: List<List<String>>,
        under20MinList: List<List<String>>,
        under5IngredientList: List<List<String>>
    )
}