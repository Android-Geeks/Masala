package com.example.masala_food_recipes.ui.fragment


import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.databinding.FragmentDetailsScreen2Binding
import com.example.masala_food_recipes.databinding.FragmentFavouriteBinding
import com.example.masala_food_recipes.ui.recyclerview.RecyclerViewAdapter2

class DetailsScreen2 : BaseFragment<FragmentDetailsScreen2Binding>(FragmentDetailsScreen2Binding::inflate) {

    override fun onCreateView() {
        val dataList = DataManager(requireContext()).getAllRecipesData()

        binding.recyclerItem.adapter=RecyclerViewAdapter2(dataList)
    }


}