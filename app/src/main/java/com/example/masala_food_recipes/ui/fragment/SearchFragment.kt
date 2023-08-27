package com.example.masala_food_recipes.ui.fragment

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.masala_food_recipes.databinding.FragmentSearchBinding
import com.example.masala_food_recipes.ui.recyclerview.SearchAdapter
import com.example.masala_food_recipes.ui.recyclerview.SearchListener


class SearchFragment :
    BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {
    private lateinit var searchList: List<List<String>>
    override fun onCreateView() {
        searchList = viewModel.searchList
        //Searching by button
        binding.buttonSearchIcon.setOnClickListener {
            val name = binding.searchBar.text.toString()
            val newList = searchList.filter {
                it[0].substring(0, name.length).equals(name, ignoreCase = true)
            }
            recyclerVisibility(newList, name)
        }

        //Searching by TextWatcher
        binding.searchBar.addTextChangedListener(
            object : TextWatcher {

                override fun afterTextChanged(s: Editable?) {
                    val name = binding.searchBar.text.toString()
                    val newList = searchList.filter {
                        it[0].substring(0, name.length).equals(name, ignoreCase = true)
                    }
                    recyclerVisibility(newList, name)
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            }
        )
    }

    private fun recyclerVisibility(newList: List<List<String>>, name: String) {
        if (newList.isEmpty() || name.isEmpty()) {          //Recycler is Empty (INVISIBLE)
            binding.apply {
                searchedRecycler.visibility = View.GONE
                emptySearch.root.visibility = View.VISIBLE
            }
        } else {                                               //Recycler is VISIBLE
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
}



