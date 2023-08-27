package com.example.masala_food_recipes.ui.fragment

import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.databinding.FragmentCuisineBinding
import com.example.masala_food_recipes.ui.recyclerview.CuisineScreenAdapter
import com.example.masala_food_recipes.ui.recyclerview.CuisineScreenListener

class CuisineScreenFragment :
    BaseFragment<FragmentCuisineBinding>(FragmentCuisineBinding::inflate) {
    override fun onCreateView() {
        val cuisinesList = viewModel.cuisineList
        binding.cuisineRecyclerFragment.adapter =
            CuisineScreenAdapter(cuisinesList, object : CuisineScreenListener {
                override fun onClick(position: Int) {
//                TODO("Not yet implemented")
                }
            })
    }
}