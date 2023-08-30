package com.example.masala_food_recipes.ui.fragment

import androidx.navigation.Navigation
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.databinding.SubCategoryFragmentBinding
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter

class UnderFiveIngredientFragment :
    BaseFragment<SubCategoryFragmentBinding>(SubCategoryFragmentBinding::inflate) {

    private lateinit var under5IngredientList : List<List<String>>
    private lateinit var recipeList : List<Recipe>

    override fun onCreateView() {

        under5IngredientList = viewModel.under5IngredientList
        recipeList = viewModel.recipes

        binding.subCategoryRecycler.adapter = SubCategoryAdapter(
                under5IngredientList, "UnderFive" ,recipeList)

        binding.topAppBar.setNavigationOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }
}