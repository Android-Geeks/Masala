package com.example.masala_food_recipes.ui.fragment

import android.content.Context
import com.example.masala_food_recipes.ui.listeners.Under20MinFragmentListener
import com.example.masala_food_recipes.databinding.SubCategoryRecyclerBinding
import com.example.masala_food_recipes.ui.recyclerview.BaseInteractionListener
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter

class UnderTwentyMinFragment :
    BaseFragment<SubCategoryRecyclerBinding>(SubCategoryRecyclerBinding::inflate),
    Under20MinFragmentListener {
    private lateinit var under20MinList: List<List<String>>
    override fun onCreateView() {
        val listener = object : BaseInteractionListener {
            override fun onClick(position: Int) {
            }
        }

        binding.subCategory.adapter =
            requireContext()
                .getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                ?.let {
                    SubCategoryAdapter(
                        under20MinList, listener, it
                    )
                }
    }

    override fun onPass(under20MinList: List<List<String>>) {
        this.under20MinList = under20MinList
    }
}
