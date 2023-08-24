package com.example.masala_food_recipes.ui.recyclerview

import com.example.masala_food_recipes.databinding.FragmentIngredientsScreenBinding
import com.example.masala_food_recipes.ui.fragment.BaseFragment

class IngredientsScreen(private val ingredients: List<String>) :
    BaseFragment<FragmentIngredientsScreenBinding>(FragmentIngredientsScreenBinding::inflate) {
    override fun onCreateView() {
        binding.ingredientRecycler.adapter = IngredientDetailsAdapter(ingredients)
    }
}



