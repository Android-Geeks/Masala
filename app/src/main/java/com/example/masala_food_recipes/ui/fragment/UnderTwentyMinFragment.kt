package com.example.masala_food_recipes.ui.fragment

import android.content.Context
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.goToDetails
import com.example.masala_food_recipes.data.listener.Under20MinFragmentListener
import com.example.masala_food_recipes.databinding.SubCategoryRecyclerBinding
import com.example.masala_food_recipes.ui.recyclerview.BaseInteractionListener
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter

class UnderTwentyMinFragment :
    BaseFragment<SubCategoryRecyclerBinding>(SubCategoryRecyclerBinding::inflate) ,
    Under20MinFragmentListener {
    private lateinit var allRecipes : List<Recipe>
    private lateinit var under20MinList : List<List<String>>
    override fun onCreateView() {
        val listener = object : BaseInteractionListener {
            override fun onClick(position : Int) {
                goToDetails(allRecipes.find { under20MinList[position][0] == it.translatedRecipeName } !!)
            }
        }
        binding.subCategory.adapter =
                requireContext().getSharedPreferences("MyPreferences" , Context.MODE_PRIVATE)
                        ?.let { SubCategoryAdapter(under20MinList , listener , it) }
    }

    override fun onPass(allRecipes : List<Recipe> , under20MinList : List<List<String>>) {
        this.allRecipes = allRecipes
        this.under20MinList = under20MinList
    }
}
