package com.example.masala_food_recipes.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.databinding.CuisineFragmentBinding
import com.example.masala_food_recipes.ui.recyclerview.CuisineScreenAdapter

class CuisineFragment :Fragment() {
    lateinit var binding: CuisineFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = CuisineFragmentBinding.inflate(inflater, container, false)
        binding.cuisineRecyclerFragment.adapter = CuisineScreenAdapter(DataManager(requireContext()).getAllRecipesData())
        return binding.root

    }


}