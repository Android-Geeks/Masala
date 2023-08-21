package com.example.masala_food_recipes.ui.fragment

import android.content.Context
import android.os.Bundle
import com.example.masala_food_recipes.MainActivity
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.util.MyViewModle
import com.example.masala_food_recipes.databinding.SubCategoryRecyclerBinding
import com.example.masala_food_recipes.ui.recyclerview.BaseInteractionListener
import com.example.masala_food_recipes.ui.recyclerview.SubCategoryAdapter

class UnderTwentyMinFragment :
    BaseFragment<SubCategoryRecyclerBinding>(SubCategoryRecyclerBinding::inflate)
{
    private var mainActivity : MainActivity? = null
    override fun onCreateView()
    {
        val listener = object : BaseInteractionListener
        {
            override fun onClick(position : Int)
            {
                val details = DetailsFragment()
                val bundle = Bundle()
                val recipe =
                        MyViewModle.allRecipes.find { MyViewModle.under20MinList[position][0] == it.translatedRecipeName }!!
                bundle.putParcelable("recipe" , recipe)
                details.arguments = bundle
                mainActivity?.inTransaction { replace(R.id.fragment_container_view , details) }
                mainActivity?.changeAppBar(R.layout.sub_app_bar)

            }
        }
        binding.subCategory.adapter =
                requireContext().getSharedPreferences("MyPreferences" , Context.MODE_PRIVATE)
                        ?.let { SubCategoryAdapter(MyViewModle.under20MinList , listener , it) }
    }

    override fun onAttach(context : Context)
    {
        super.onAttach(context)
        if (context is MainActivity)
        {
            mainActivity = context
        }
    }
}
