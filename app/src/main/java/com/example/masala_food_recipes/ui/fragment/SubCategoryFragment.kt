package com.example.masala_food_recipes.ui.fragment

import androidx.navigation.Navigation
import com.example.masala_food_recipes.databinding.SubCategoryFragmentBinding
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter

class SubCategoryFragment : BaseFragment<SubCategoryFragmentBinding> (SubCategoryFragmentBinding::inflate) {

    override fun onCreateView() {
        binding.upBar.toolBar.setNavigationOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }


}