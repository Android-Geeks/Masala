package com.example.masala_food_recipes.ui.fragment

import android.content.Context
import com.example.masala_food_recipes.data.interactors.goToDetails
import com.example.masala_food_recipes.data.util.MyViewModle
import com.example.masala_food_recipes.databinding.SubCategoryRecyclerBinding
import com.example.masala_food_recipes.ui.recyclerview.BaseInteractionListener
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter

class UnderTwentyMinFragment :
    BaseFragment<SubCategoryRecyclerBinding>(SubCategoryRecyclerBinding::inflate)
{
    override fun onCreateView()
    {
        val listener = object : BaseInteractionListener
        {
            override fun onClick(position : Int)
            {
                goToDetails(
                        MyViewModle.allRecipes.find { MyViewModle.under20MinList[position][0] == it.translatedRecipeName }!!
                )

            }
        }
        binding.subCategory.adapter =
                requireContext().getSharedPreferences("MyPreferences" , Context.MODE_PRIVATE)
                        ?.let { SubCategoryAdapter(MyViewModle.under20MinList , listener , it) }
    }
}
