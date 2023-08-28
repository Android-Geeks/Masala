package com.example.masala_food_recipes.ui.fragment

import androidx.navigation.Navigation
import com.example.masala_food_recipes.databinding.SubCategoryFragmentBinding
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter

class UnderFiveIngredientFragment :
    BaseFragment<SubCategoryFragmentBinding>(SubCategoryFragmentBinding::inflate) {

    private lateinit var under5IngredientList : List<List<String>>

    override fun onCreateView() {

        under5IngredientList = viewModel.under5IngredientList

        binding.subCategoryRecycler.adapter = SubCategoryAdapter(
                under5IngredientList)

        binding.upBar.toolBar.setNavigationOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }
}