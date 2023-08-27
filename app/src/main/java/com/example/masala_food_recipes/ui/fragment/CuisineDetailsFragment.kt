package com.example.masala_food_recipes.ui.fragment

import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.data.util.Constants
import com.example.masala_food_recipes.data.util.PreferencesUtil
import com.example.masala_food_recipes.databinding.FragmentCuisineDetailsBinding
import com.example.masala_food_recipes.ui.recyclerview.CuisineDetailsAdapter
import com.example.masala_food_recipes.ui.recyclerview.CuisineDetailsListener

class CuisineDetailsFragment  :
    BaseFragment<FragmentCuisineDetailsBinding>(FragmentCuisineDetailsBinding::inflate) {
    override fun onCreateView() {
        val recipes by lazy { DataManager(requireContext()).getAllRecipesData() }
        val cuisineName = PreferencesUtil.getFromSharedPref(Constants.CUISINE_KEY)
        if (cuisineName!!.isNotEmpty()) {
            val cuisinesList by lazy { Cuisines(recipes).getCuisineDetails(cuisineName) }
            binding.apply {
                cuisineType.text = cuisineName
                cuisineRecyclerFragment.adapter =
                    CuisineDetailsAdapter(cuisinesList, object : CuisineDetailsListener {
                        override fun onClick(position: Int) {
                            TODO("Not yet implemented")
                        }
                    })
            }
        }
    }
}