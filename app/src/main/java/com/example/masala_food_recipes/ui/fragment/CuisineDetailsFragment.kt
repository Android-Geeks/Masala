package com.example.masala_food_recipes.ui.fragment

import androidx.navigation.Navigation
import com.example.masala_food_recipes.data.util.Constants
import com.example.masala_food_recipes.data.util.PreferencesUtil
import com.example.masala_food_recipes.databinding.FragmentCuisineDetailsBinding
import com.example.masala_food_recipes.ui.recyclerview.CuisineDetailsAdapter
import com.example.masala_food_recipes.ui.recyclerview.CuisineDetailsItemPadding
import com.example.masala_food_recipes.ui.recyclerview.CuisineDetailsListener

class CuisineDetailsFragment  :
    BaseFragment<FragmentCuisineDetailsBinding>(FragmentCuisineDetailsBinding::inflate) {
    override fun onCreateView() {

        val cuisineFromHome = PreferencesUtil.getFromSharedPref(Constants.CUISINE_KEY)
        val cuisineFromViewAll =  PreferencesUtil.getFromSharedPref(Constants.CUISINE_SCREEN_KEY)

        if (cuisineFromHome != null)   buildingFragmentContent(cuisineFromHome)

        if (cuisineFromViewAll != null)   buildingFragmentContent(cuisineFromViewAll)


    }
    private fun buildingFragmentContent(cuisineName : String){

            val cuisinesList = viewModel.cuisineList
            binding.apply {
                cuisineType.text = cuisineName
                cuisineRecyclerFragment.adapter =
                    CuisineDetailsAdapter(cuisinesList, object : CuisineDetailsListener {
                        override fun onClick(position: Int) {
                            TODO("Not yet implemented")
                        }
                    })
                cuisineRecyclerFragment.addItemDecoration(CuisineDetailsItemPadding(16,cuisinesList.size-1))
                cuisineType.setOnClickListener {
                    Navigation.findNavController(it).popBackStack()
                }
            }
    }
}