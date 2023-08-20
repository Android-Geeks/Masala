package com.example.masala_food_recipes.ui.fragment

import android.util.Log
import com.example.masala_food_recipes.databinding.FragmentFavouriteBinding
import com.example.masala_food_recipes.ui.recyclerview.FavouriteAdapter
import com.example.masala_food_recipes.ui.recyclerview.FavouriteListener
import com.example.masala_food_recipes.util.Constants
import com.example.masala_food_recipes.util.PreferencesUtil

class FavouriteFragment : BaseFragment<FragmentFavouriteBinding>(FragmentFavouriteBinding :: inflate) {
    override fun onCreateView() {
        //TODO("Not yet implemented")
        PreferencesUtil.init(requireContext())
        val po = PreferencesUtil.getFromSharedPref("pop")
//        Log.v("MainActivity", listOf(po).toString())

//        val k =  listOf(PreferencesUtil.getFromSharedPref(Constants.KEY_NAME)!!.toList(),
//            PreferencesUtil.getFromSharedPref(Constants.KEY_TIME)!!.toList(),
//            PreferencesUtil.getFromSharedPref(Constants.KEY_IMAGE)!!.toList()).map { it.toString() }
//        Log.v("MainActivity",k.toString())
//
//            binding.favoriteRecycler.adapter = FavouriteAdapter(listOf(k), object :
//                FavouriteListener {})

    }

}
