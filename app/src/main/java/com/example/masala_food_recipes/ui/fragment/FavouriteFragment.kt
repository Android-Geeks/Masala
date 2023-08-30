package com.example.masala_food_recipes.ui.fragment

import android.view.View
import androidx.navigation.Navigation
import com.example.masala_food_recipes.data.interactors.Favourite
import com.example.masala_food_recipes.databinding.FragmentFavouriteBinding
import com.example.masala_food_recipes.ui.FavouritesInteractionListener
import com.example.masala_food_recipes.ui.recyclerview.FavouriteScreenAdapter

class FavouriteFragment :
    BaseFragment<FragmentFavouriteBinding>(FragmentFavouriteBinding::inflate),
    FavouritesInteractionListener {
    private val adapter by lazy { FavouriteScreenAdapter(this) }
    override fun onCreateView() {

        if (Favourite.getFavouriteList().isNotEmpty()) {
            adapter.differ.submitList(Favourite.getFavouriteList())
            binding.recyclerView.adapter = adapter
        } else {
            onEmptyFavourite()
        }

        binding.apply {
            this.include2.toolBar.setNavigationOnClickListener {
                Navigation.findNavController(it).popBackStack()
            }
        }
    }

    override fun onEmptyFavourite() {
        binding.apply {
            recyclerView.visibility = View.GONE
            recyclerView.layoutParams.height = 0
            recyclerView.layoutParams.width = 0
            emptyFav.visibility = View.VISIBLE
        }
    }

    override fun onRecipeClicked(recipe: List<String>) {
        val action =
            FavouriteFragmentDirections.actionFavouriteFragmentToDetailsFragment(viewModel.recipes.filter {
                it.translatedRecipeName == recipe[0] &&
                        it.totalTimeInMins == recipe[1] &&
                        it.imageUrl == recipe[2]
            }[0])
        Navigation.findNavController(requireView()).navigate(action)
    }

}