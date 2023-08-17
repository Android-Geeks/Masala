package com.example.masala_food_recipes.ui.fragment

import android.content.Intent
import com.example.masala_food_recipes.DetailsActivity
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.interactors.UnderFiveIngredient
import com.example.masala_food_recipes.databinding.SubCategoryRecyclerBinding
import com.example.masala_food_recipes.ui.recyclerview.BaseInteractionListener
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter

class UnderFiveIngredientFragment :
    BaseFragment<SubCategoryRecyclerBinding>(SubCategoryRecyclerBinding::inflate) {
    override fun onCreateView() {
        val allRecipes = DataManager(this.requireContext()).getAllRecipesData()
        val under5Ingredient =
                UnderFiveIngredient(allRecipes).execute()
        val listener = object : BaseInteractionListener
        {
            override fun onClick(position : Int)
            {
                val recipe = allRecipes.find { under5Ingredient[position][0] == it.translatedRecipeName }!!
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("recipe",recipe)
                startActivity(intent)
            }

        }

        binding.subCategory.adapter = SubCategoryAdapter(under5Ingredient, listener)
    }
}