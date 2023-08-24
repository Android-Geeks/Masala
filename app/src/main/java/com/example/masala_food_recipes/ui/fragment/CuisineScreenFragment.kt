package com.example.masala_food_recipes.ui.fragment

import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.databinding.FragmentCuisineBinding
import com.example.masala_food_recipes.ui.recyclerview.CuisineScreenAdapter
import com.example.masala_food_recipes.ui.recyclerview.CuisineScreenListener
import com.example.masala_food_recipes.ui.recyclerview.CuisineItemPaddingDecoration

class CuisineScreenFragment:BaseFragment<FragmentCuisineBinding>(FragmentCuisineBinding :: inflate) {
    override fun onCreateView() {
        val recipes by lazy { DataManager(requireContext()).getAllRecipesData() }
        val cuisinesList by lazy { Cuisines(recipes).getCuisineCards() }
        binding.apply {
            cuisineRecyclerFragment.adapter = CuisineScreenAdapter(cuisinesList, object : CuisineScreenListener {})
            cuisineRecyclerFragment.addItemDecoration(CuisineItemPaddingDecoration(16,cuisinesList.size-1))

            cuisineText.setOnClickListener { v ->
                navigateTo(v, R.id.action_cuisineScreenFragment_to_homeFragment2)
            }
        }
    }
}