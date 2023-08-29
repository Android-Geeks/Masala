package com.example.masala_food_recipes.ui.fragment

import android.view.View
import androidx.navigation.Navigation
import com.example.masala_food_recipes.data.interactors.Favourite
import com.example.masala_food_recipes.databinding.FragmentFavouriteBinding
import com.example.masala_food_recipes.ui.recyclerview.FavouriteScreenAdapter

class FavouriteFragment :
    BaseFragment<FragmentFavouriteBinding>(FragmentFavouriteBinding::inflate) {
    private val adapter by lazy { FavouriteScreenAdapter }
    override fun onCreateView() {

        if (Favourite.getFavouriteList().isNotEmpty()) {
            adapter.differ.submitList(Favourite.getFavouriteList())

            binding.apply {
                recyclerView.adapter = adapter
            }
        } else {
            binding.apply {

                recyclerView.visibility = View.GONE
                recyclerView.layoutParams.height = 0
                recyclerView.layoutParams.width = 0
                emptyFav.visibility = View.VISIBLE
            }
        }


        binding.apply {
            this.include2.toolBar.setNavigationOnClickListener {
                Navigation.findNavController(it).popBackStack()

            }
        }
    }

}