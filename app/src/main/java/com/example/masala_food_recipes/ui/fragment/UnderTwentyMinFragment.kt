package com.example.masala_food_recipes.ui.fragment

import androidx.navigation.Navigation
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.databinding.SubCategoryFragmentBinding
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter

class UnderTwentyMinFragment :
    BaseFragment<SubCategoryFragmentBinding>(SubCategoryFragmentBinding::inflate) {

    private lateinit var under20MinList: List<List<String>>
    private lateinit var recipeList: List<Recipe>

    override fun onCreateView() {

        under20MinList = viewModel.under20MinList

        recipeList = viewModel.recipes

        binding.subCategoryRecycler.adapter = SubCategoryAdapter(
            under20MinList, "UnderTwenty", recipeList
        )

        binding.topAppBar.setNavigationOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }
}
