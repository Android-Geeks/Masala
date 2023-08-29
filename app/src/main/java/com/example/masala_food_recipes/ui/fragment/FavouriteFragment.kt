package com.example.masala_food_recipes.ui.fragment

import androidx.navigation.Navigation
import android.view.View
import com.example.masala_food_recipes.data.interactors.Favourite
import com.example.masala_food_recipes.databinding.FragmentFavouriteBinding
import com.example.masala_food_recipes.ui.recyclerview.FavouriteScreenAdapter

class FavouriteFragment :
    BaseFragment<FragmentFavouriteBinding>(FragmentFavouriteBinding::inflate) {
    private val adapter by lazy { FavouriteScreenAdapter() }
    override fun onCreateView() {

        val favList = Favourite.getFavouriteList()

        if (favList.isNotEmpty()) {
            adapter.differ.submitList(favList)

            binding.apply {
                recyclerView.adapter = adapter
                emptyFav.visibility = View.GONE
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