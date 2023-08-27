package com.example.masala_food_recipes.ui.fragment

import android.content.Context
import com.example.masala_food_recipes.databinding.SubCategoryRecyclerBinding
import com.example.masala_food_recipes.ui.recyclerview.BaseInteractionListener
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter

class UnderFiveIngredientFragment :
    BaseFragment<SubCategoryRecyclerBinding>(SubCategoryRecyclerBinding::inflate) {
    private lateinit var under5IngredientList: List<List<String>>
    override fun onCreateView() {
        under5IngredientList = viewModel.under5IngredientList
        val listener = object : BaseInteractionListener {
            override fun onClick(position: Int) {
            }
        }
        binding.subCategory.adapter =
            requireContext()
                .getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                ?.let {
                    SubCategoryAdapter(
                        under5IngredientList, listener, it
                    )
                }
    }


}