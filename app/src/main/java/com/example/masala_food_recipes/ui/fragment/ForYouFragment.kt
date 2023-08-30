package com.example.masala_food_recipes.ui.fragment

import androidx.navigation.Navigation
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.databinding.SubCategoryFragmentBinding
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryItemPadding


class ForYouFragment :
    BaseFragment<SubCategoryFragmentBinding>(SubCategoryFragmentBinding::inflate) {

    private lateinit var forYouList: List<List<String>>
    private lateinit var recipeList: List<Recipe>

    override fun onCreateView() {

        forYouList = viewModel.forYouList
        recipeList = viewModel.recipes

        binding.subCategoryRecycler.adapter = SubCategoryAdapter(
            forYouList, "ForYou" ,recipeList
        )
        binding.subCategoryRecycler.addItemDecoration(SubCategoryItemPadding(16))


        binding.upBar.toolBar.setNavigationOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }


}