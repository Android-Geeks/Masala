package com.example.masala_food_recipes.ui.recyclerview


import com.example.masala_food_recipes.databinding.FragmentInstructionsScreenBinding
import com.example.masala_food_recipes.ui.fragment.BaseFragment

class InstructionsScreen :
    BaseFragment<FragmentInstructionsScreenBinding>(FragmentInstructionsScreenBinding::inflate) {
    override fun onCreateView() {
        binding.instructionRecycler.adapter = InstructionDetailsAdapter(viewModel.instructions)
    }
}