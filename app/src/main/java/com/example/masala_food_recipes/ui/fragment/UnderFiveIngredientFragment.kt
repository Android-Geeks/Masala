package com.example.masala_food_recipes.ui.fragment

import AdaptiveSpacingItemDecoration
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.interactors.UnderFiveIngredient
import com.example.masala_food_recipes.databinding.SubCategoryRecyclerBinding
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter

class UnderFiveIngredientFragment :
    BaseFragment<SubCategoryRecyclerBinding>(SubCategoryRecyclerBinding::inflate) {
    override fun onCreateView() {
        val under5Ingredient =
            UnderFiveIngredient(DataManager(this.requireContext()).getAllRecipesData()).execute()
        binding.subCategory.addItemDecoration(AdaptiveSpacingItemDecoration(32, false))
        binding.subCategory.adapter = SubCategoryAdapter(under5Ingredient, null)
    }
}