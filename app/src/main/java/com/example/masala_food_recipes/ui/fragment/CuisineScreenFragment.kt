package com.example.masala_food_recipes.ui.fragment

import androidx.navigation.Navigation
import com.example.masala_food_recipes.databinding.FragmentCuisineBinding
import com.example.masala_food_recipes.ui.recyclerview.CuisineScreenAdapter
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryItemPadding

class CuisineScreenFragment :
    BaseFragment<FragmentCuisineBinding>(FragmentCuisineBinding::inflate) {
    override fun onCreateView() {
        val cuisinesList = viewModel.cuisineList
        binding.cuisineRecyclerFragment.adapter = CuisineScreenAdapter(cuisinesList)

        binding.cuisineRecyclerFragment.addItemDecoration(SubCategoryItemPadding(16))
        binding.upBar.toolBar.setNavigationOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }
}