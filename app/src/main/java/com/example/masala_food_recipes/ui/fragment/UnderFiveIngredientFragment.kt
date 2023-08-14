package com.example.masala_food_recipes.ui.fragment

import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.interactors.UnderFiveIngredient
import com.example.masala_food_recipes.databinding.SubCategoryRecyclerBinding
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter

class UnderFiveIngredientFragment :
    BaseFragment<SubCategoryRecyclerBinding>(SubCategoryRecyclerBinding::inflate) {
    override fun onCreateView() {
        val under_5_ingredient =
                UnderFiveIngredient(DataManager(this.requireContext()).getAllRecipesData()).execute()
        binding.subCategory.adapter = SubCategoryAdapter(under_5_ingredient , null)
    }
}