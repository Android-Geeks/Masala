package com.example.masala_food_recipes.ui.fragment

import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.interactors.UnderTwentyMinsRecipe
import com.example.masala_food_recipes.databinding.SubCategoryRecyclerBinding
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter

class UnderTwentyMinFragment :
    BaseFragment<SubCategoryRecyclerBinding>(SubCategoryRecyclerBinding::inflate) {
    override fun onCreateView() {
        val under_20_min =
                UnderTwentyMinsRecipe(DataManager(this.requireContext()).getAllRecipesData()).execute()
        binding.subCategory.adapter = SubCategoryAdapter(under_20_min , null)
    }
}