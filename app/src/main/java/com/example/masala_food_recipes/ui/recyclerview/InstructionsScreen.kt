package com.example.masala_food_recipes.ui.recyclerview


import androidx.recyclerview.widget.LinearLayoutManager
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.databinding.FragmentInstructionsScreenBinding
import com.example.masala_food_recipes.ui.fragment.BaseFragment

class InstructionsScreen : BaseFragment<FragmentInstructionsScreenBinding>(FragmentInstructionsScreenBinding::inflate) {
    override fun onCreateView() {
        val dataList = DataManager(requireContext()).getAllRecipesData()
        val recyclerview = binding.recyclerView2
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView2.adapter= RecyclerViewAdapter2(dataList)
    }


}