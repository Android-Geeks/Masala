package com.example.masala_food_recipes.ui.fragment
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.databinding.FragmentDetailsScreen1Binding
import com.example.masala_food_recipes.ui.recyclerview.RecyclerViewAdapter1

class DetailsScreen1 : BaseFragment<FragmentDetailsScreen1Binding>(FragmentDetailsScreen1Binding::inflate) {



    override fun onCreateView() {
        val dataList = DataManager(requireContext()).getAllRecipesData()
        binding.recyclerView.adapter=RecyclerViewAdapter1(dataList)
    }


}