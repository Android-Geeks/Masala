package com.example.masala_food_recipes.ui.fragment

import android.view.View
import com.example.masala_food_recipes.data.listener.SearchFragmentListener
import com.example.masala_food_recipes.databinding.FragmentSearchBinding
import com.example.masala_food_recipes.ui.recyclerview.SearchAdapter
import com.example.masala_food_recipes.ui.recyclerview.SearchListener


class SearchFragment :
    BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate), SearchFragmentListener {
        private lateinit var searchList : List<List<String>>
    override fun onCreateView() {

        binding.buttonSearchIcon.setOnClickListener {
            val name = binding.searchBar.text.toString()
            val newList = searchList.filter {
                it[0].substring(0, name.length).equals(name, ignoreCase = true)
            }
            recyclerVisibility(newList, name)
        }
    }
    private fun recyclerVisibility(newList : List<List<String>>, name : String){
        if (newList.isEmpty() || name.isEmpty()) {          //Recycler is Empty (IN VISIBLE)
            binding.apply {
                searchedRecycler.visibility = View.GONE
                emptySearch.root.visibility = View.VISIBLE
            }
        }
        else{                                               //Recycler is VISIBLE
            binding.apply {
                emptySearch.root.visibility = View.GONE
                searchedRecycler.visibility = View.VISIBLE
                searchedRecycler.adapter = SearchAdapter(newList, object : SearchListener {
                    override fun onClick(position: Int) {
                        TODO("Not yet implemented")
                    }
                })
            }
        }
    }

    override fun onPass(recipes: List<List<String>>) {
        searchList = recipes
    }

}



