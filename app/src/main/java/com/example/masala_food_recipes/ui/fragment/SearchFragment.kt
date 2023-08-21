package com.example.masala_food_recipes.ui.fragment

import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.interactors.SearchRecipe
import com.example.masala_food_recipes.databinding.FragmentSearchBinding
import com.example.masala_food_recipes.ui.recyclerview.SearchAdapter
import com.example.masala_food_recipes.ui.recyclerview.SearchListener


class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding :: inflate) {
    override fun onCreateView() {
        val recipeList = DataManager(requireContext()).getAllRecipesData()
        val searchList = SearchRecipe(recipeList).execute()
        binding.searchedRecycler.adapter = SearchAdapter(searchList, object : SearchListener {})

        binding.buttonSearch.setOnClickListener {
                val name = binding.searchBar.text.toString()
                val newList = searchList.filter { it[0].substring(0, name.length).equals(name, ignoreCase = true) }
                binding.searchedRecycler.adapter = SearchAdapter(newList, object : SearchListener {})

            }
        }
}



