package com.example.masala_food_recipes.ui.fragment

import android.content.Context
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.goToDetails
import com.example.masala_food_recipes.data.listener.Under5IngredientFragmentListener
import com.example.masala_food_recipes.databinding.SubCategoryRecyclerBinding
import com.example.masala_food_recipes.ui.recyclerview.BaseInteractionListener
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter

class UnderFiveIngredientFragment :
    BaseFragment<SubCategoryRecyclerBinding>(SubCategoryRecyclerBinding::inflate) ,
    Under5IngredientFragmentListener {
    private lateinit var allRecipes : List<Recipe>
    private lateinit var under5IngredientList : List<List<String>>
    override fun onCreateView() {
        val listener = object : BaseInteractionListener {
            override fun onClick(position : Int) {
                goToDetails(allRecipes.find { under5IngredientList[position][0] == it.translatedRecipeName } !!)
            }
        }
        binding.subCategory.adapter =
                requireContext().getSharedPreferences("MyPreferences" , Context.MODE_PRIVATE)?.let {
                    SubCategoryAdapter(
                            under5IngredientList , listener , it)
                }
    }

    override fun onPass(allRecipes : List<Recipe> , under5IngredientList : List<List<String>>) {
        this.allRecipes = allRecipes
        this.under5IngredientList = under5IngredientList
    }

}