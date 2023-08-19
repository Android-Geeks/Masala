package com.example.masala_food_recipes.ui.fragment

import android.content.Intent
import com.example.masala_food_recipes.DetailsActivity
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
                val recipe =
                        MyViewModle.allRecipes.find { MyViewModle.under20MinList[position][0] == it.translatedRecipeName }!!
                val intent = Intent(context , DetailsActivity::class.java)
                intent.putExtra("recipe" , recipe)
                startActivity(intent)
            }
        }
        binding.subCategory.adapter = SubCategoryAdapter(MyViewModle.under20MinList , listener)
    }
}
