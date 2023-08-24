package com.example.masala_food_recipes.ui.fragment

import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.databinding.FragmentDetailsBinding

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {
    override fun onCreateView() {
        val recipe = arguments?.getParcelable<Recipe>("recipe")
        binding.textview.text = recipe?.translatedRecipeName
    }
}