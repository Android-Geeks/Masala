package com.example.masala_food_recipes.ui.fragment

import android.content.Context
import androidx.navigation.Navigation
import com.example.masala_food_recipes.databinding.SubCategoryFragmentBinding
import com.example.masala_food_recipes.ui.recyclerview.BaseInteractionListener
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter

class UnderTwentyMinFragment :
    BaseFragment<SubCategoryFragmentBinding>(SubCategoryFragmentBinding::inflate) {
    private lateinit var under20MinList: List<List<String>>
    override fun onCreateView() {
        under20MinList = viewModel.under20MinList
        val listener = object : BaseInteractionListener {
            override fun onClick(position: Int) {
            }
        }

        binding.subCategoryRecycler.adapter =
            requireContext()
                .getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                ?.let {
                    SubCategoryAdapter(
                        under20MinList, listener, it
                    )
                }
        binding.upBar.toolBar.setNavigationOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }
}
