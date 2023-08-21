package com.example.masala_food_recipes.ui.recyclerview

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.databinding.FragmentIngredientsScreenBinding
import com.example.masala_food_recipes.ui.fragment.BaseFragment

class IngredientsScreen(private val ingredients: List<String>) :
    BaseFragment<FragmentIngredientsScreenBinding>(FragmentIngredientsScreenBinding::inflate) {


    override fun onCreateView() {
        binding.recyclerView1.adapter = RecyclerViewAdapter1(ingredients)
    }


}



