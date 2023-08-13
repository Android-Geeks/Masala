package com.example.masala_food_recipes.ui.fragment

import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.databinding.CuisineScreenCardBinding
import com.example.masala_food_recipes.databinding.FragmentCuisineBinding
import com.example.masala_food_recipes.ui.recyclerview.CuisineScreenAdapter
import com.example.masala_food_recipes.ui.recyclerview.CuisineScreenListener

class CuisineScreenFragment:BaseFragment<FragmentCuisineBinding>(FragmentCuisineBinding :: inflate) {
    override fun onCreateView() {
        binding.cuisineRecyclerFragment.adapter = CuisineScreenAdapter(DataManager(requireContext()).getAllRecipesData(),object :CuisineScreenListener{})
    }
}