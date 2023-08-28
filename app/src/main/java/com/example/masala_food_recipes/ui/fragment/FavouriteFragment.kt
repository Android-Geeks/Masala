package com.example.masala_food_recipes.ui.fragment

import androidx.navigation.Navigation
import com.example.masala_food_recipes.databinding.FragmentFavouriteBinding

class FavouriteFragment :
    BaseFragment<FragmentFavouriteBinding>(FragmentFavouriteBinding::inflate) {
    override fun onCreateView() {
        //TODO("Not yet implemented")
        binding.apply {
            this.include2.toolBar.setNavigationOnClickListener {
                Navigation.findNavController(it).popBackStack()

            }
        }

    }
}