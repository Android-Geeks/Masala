package com.example.masala_food_recipes.ui.fragment

import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.databinding.FragmentCuisineDetailsBinding

class CuisineDetailsFragment  :
    BaseFragment<FragmentCuisineDetailsBinding>(FragmentCuisineDetailsBinding::inflate) {
    override fun onCreateView() {
        val recipes by lazy { DataManager(requireContext()).getAllRecipesData() }
        val cuisinesList by lazy { Cuisines(recipes).getCuisineDetails() }
    }
}