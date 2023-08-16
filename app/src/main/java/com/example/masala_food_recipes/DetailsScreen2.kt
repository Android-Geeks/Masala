package com.example.masala_food_recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.databinding.FragmentFavouriteBinding
import com.example.masala_food_recipes.ui.fragment.BaseFragment
import com.example.masala_food_recipes.ui.recyclerview.RecyclerViewAdapter2

class DetailsScreen2 : BaseFragment<FragmentFavouriteBinding>(FragmentFavouriteBinding::inflate) {
    private lateinit var recyclerView : RecyclerView
    lateinit var adapter : RecyclerViewAdapter2
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_details_screen2, container, false)
        recyclerView = view.findViewById(R.id.recycler_item)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val dataList = DataManager(requireContext()).getAllRecipesData()
        adapter = RecyclerViewAdapter2(dataList)
        recyclerView.adapter = adapter
        return view
    }

    override fun onCreateView() {
        TODO("Not yet implemented")
    }


}