package com.example.masala_food_recipes.ui.fragment

import android.content.Context
import com.example.masala_food_recipes.databinding.FragmentFavouriteBinding
import com.example.masala_food_recipes.ui.recyclerview.FavouriteScreenAdapter


class FavouriteFragment :
    BaseFragment<FragmentFavouriteBinding>(FragmentFavouriteBinding::inflate) {
    private val adapter by lazy { FavouriteScreenAdapter() }
    override fun onCreateView() {
        val sharedPref = requireContext().getSharedPreferences("Favourites", Context.MODE_PRIVATE)

        val favList = mutableListOf<List<String>>(

            listOf(
                "masalsa",
                "20",
                "https://dfstudio-d420.kxcdn.com/wordpress/wp-content/uploads/2019/06/digital_camera_photo-980x653.jpg"
            ),
            listOf(
                "masalsa",
                "20",
                "https://dfstudio-d420.kxcdn.com/wordpress/wp-content/uploads/2019/06/digital_camera_photo-980x653.jpg"
            ),
            listOf(
                "masalsa",
                "20",
                "https://dfstudio-d420.kxcdn.com/wordpress/wp-content/uploads/2019/06/digital_camera_photo-980x653.jpg"
            )
        )
        //val favList by lazy { sharedPref.getStringSet("Favourite", emptySet())?.toList() ?: emptyList() }

        adapter.differ.submitList(favList)


        binding.recyclerView.adapter = adapter


    }

}