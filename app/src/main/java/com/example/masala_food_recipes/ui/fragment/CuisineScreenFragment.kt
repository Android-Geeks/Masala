package com.example.masala_food_recipes.ui.fragment

import androidx.navigation.Navigation
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

        binding.upBar.toolBar.setNavigationOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }
}