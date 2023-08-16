package com.example.masala_food_recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.ui.recyclerview.RecyclerViewAdapter1


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class DetailsScreen1 : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerView : RecyclerView
    lateinit var adapter : RecyclerViewAdapter1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_details_screen1, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val dataList = DataManager(requireContext()).getAllRecipesData()
        adapter = RecyclerViewAdapter1(dataList)
        recyclerView.adapter = adapter

        recyclerView.adapter = adapter



        return view
    }


}