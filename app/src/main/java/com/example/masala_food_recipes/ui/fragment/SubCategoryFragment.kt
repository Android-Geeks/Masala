package com.example.masala_food_recipes.ui.fragment

import androidx.navigation.Navigation
import com.example.masala_food_recipes.databinding.SubCategoryFragmentBinding

class SubCategoryFragment : BaseFragment<SubCategoryFragmentBinding> (SubCategoryFragmentBinding::inflate) {

    override fun onCreateView() {
        val forYouList = viewModel.forYouList
        binding.apply {
            upBar.toolBar.setNavigationOnClickListener {
                Navigation.findNavController(it).popBackStack()
            }

        }
    }
}
