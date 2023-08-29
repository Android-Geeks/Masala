package com.example.masala_food_recipes.ui.fragment

import androidx.navigation.Navigation
import android.content.Context
import android.view.View
import com.example.masala_food_recipes.databinding.FragmentFavouriteBinding
import com.example.masala_food_recipes.ui.recyclerview.FavouriteScreenAdapter

class FavouriteFragment :
    BaseFragment<FragmentFavouriteBinding>(FragmentFavouriteBinding::inflate) {
    private val adapter by lazy { FavouriteScreenAdapter() }
    override fun onCreateView() {
        //val sharedPref = requireContext().getSharedPreferences("Favourites", Context.MODE_PRIVATE)

        val favList = mutableListOf<List<String>>(

//            listOf(
//                "masalsa",
//                "20",
//                "https://dfstudio-d420.kxcdn.com/wordpress/wp-content/uploads/2019/06/digital_camera_photo-980x653.jpg"
//            ),
//            listOf(
//                "masalsa",
//                "20",
//                "https://dfstudio-d420.kxcdn.com/wordpress/wp-content/uploads/2019/06/digital_camera_photo-980x653.jpg"
//            ),
//            listOf(
//                "masalsa",
//                "20",
//                "https://dfstudio-d420.kxcdn.com/wordpress/wp-content/uploads/2019/06/digital_camera_photo-980x653.jpg"
//            )
        )
        //val favList by lazy { sharedPref.getStringSet("Favourite", emptySet())?.toList() ?: emptyList() }


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