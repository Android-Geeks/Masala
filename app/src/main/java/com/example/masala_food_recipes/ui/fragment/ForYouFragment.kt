package com.example.masala_food_recipes.ui.fragment

import android.content.Context
import androidx.navigation.Navigation
import com.example.masala_food_recipes.databinding.SubCategoryFragmentBinding
import com.example.masala_food_recipes.ui.recyclerview.BaseInteractionListener
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter

class ForYouFragment:
    BaseFragment<SubCategoryFragmentBinding>(SubCategoryFragmentBinding::inflate) {
    private lateinit var forYouList: List<List<String>>
    override fun onCreateView() {
        forYouList = viewModel.forYouList
        val listener = object : BaseInteractionListener {
            override fun onClick(position: Int) {
            }
        }
        binding.subCategoryRecycler.adapter =
            requireContext()
                .getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                ?.let {
                    SubCategoryAdapter(
                        forYouList, listener, it
                    )
                }
        binding.upBar.toolBar.setNavigationOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }


}