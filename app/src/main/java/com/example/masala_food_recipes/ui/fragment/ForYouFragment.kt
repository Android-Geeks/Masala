package com.example.masala_food_recipes.ui.fragment

import androidx.navigation.Navigation
import com.example.masala_food_recipes.databinding.SubCategoryFragmentBinding
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter


class ForYouFragment :
    BaseFragment<SubCategoryFragmentBinding>(SubCategoryFragmentBinding::inflate) {

    private lateinit var forYouList: List<List<String>>

    override fun onCreateView() {

        forYouList = viewModel.forYouList

        binding.subCategoryRecycler.adapter = SubCategoryAdapter(
            forYouList, true
        )


        binding.upBar.toolBar.setNavigationOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }


}