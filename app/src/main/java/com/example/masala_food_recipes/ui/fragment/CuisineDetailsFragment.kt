package com.example.masala_food_recipes.ui.fragment

import androidx.navigation.Navigation
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.data.util.Constants
import com.example.masala_food_recipes.data.util.PreferencesUtil
import com.example.masala_food_recipes.databinding.FragmentCuisineDetailsBinding
import com.example.masala_food_recipes.databinding.SubCategoryFragmentBinding
import com.example.masala_food_recipes.ui.recyclerview.CuisineDetailsAdapter
import com.example.masala_food_recipes.ui.recyclerview.CuisineDetailsItemPadding

class CuisineDetailsFragment :
    BaseFragment<SubCategoryFragmentBinding>(SubCategoryFragmentBinding::inflate) {
    override fun onCreateView() {

        val cuisineFromHome = PreferencesUtil.getFromSharedPref(Constants.CUISINE_KEY)

        if (cuisineFromHome != null) {
            buildingFragmentContent(cuisineFromHome)
        }
    }

    private fun buildingFragmentContent(cuisineName: String) {

        val recipes = viewModel.recipes
        val cuisinesList by lazy { Cuisines(recipes).getCuisineDetails(cuisineName) }

        binding.apply {
            topAppBar.title = cuisineName
            subCategoryRecycler.adapter = CuisineDetailsAdapter(cuisinesList, recipes)
            topAppBar.setNavigationOnClickListener {
                Navigation.findNavController(it).popBackStack()
            }
        }
    }
}