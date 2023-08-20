package com.example.masala_food_recipes.ui.fragment

import com.example.masala_food_recipes.databinding.FragmentFavouriteBinding
import com.example.masala_food_recipes.ui.recyclerview.FavouriteAdapter
import com.example.masala_food_recipes.ui.recyclerview.FavouriteListener
import com.example.masala_food_recipes.util.Constants
import com.example.masala_food_recipes.util.PreferencesUtil

class FavouriteFragment : BaseFragment<FragmentFavouriteBinding>(FragmentFavouriteBinding :: inflate) {
    override fun onCreateView() {
        //TODO("Not yet implemented")
        PreferencesUtil.init(requireContext())
        val po = listOf(PreferencesUtil.getFromSharedPref(Constants.KEY_NAME)!!,
            "_",PreferencesUtil.getFromSharedPref(Constants.KEY_IMAGE)!!)

            binding.favoriteRecycler.adapter = FavouriteAdapter(listOf(po), object :
                FavouriteListener {})

    }

}
