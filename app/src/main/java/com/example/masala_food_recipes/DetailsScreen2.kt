package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.interactors.RecyclerViewAdapter2


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class DetailsScreen2 : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewPager: ViewPager2
    private lateinit var nextFragmentButton: Button
    private lateinit var prevFragmentButton: Button
    private lateinit var adapter: RecyclerViewAdapter2
    private lateinit var recyclerView: RecyclerView

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


        val view = inflater.inflate(R.layout.fragment_details_screen2, container, false)
        recyclerView = view.findViewById(R.id.recycler_item)
        viewPager = requireActivity().findViewById(R.id.viewPager)
        nextFragmentButton = view.findViewById(R.id.button_2)
        prevFragmentButton = view.findViewById(R.id.button_1)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val dataList = DataManager(requireContext()).getAllRecipesData()
        val adapter = RecyclerViewAdapter2(dataList)
        recyclerView.adapter = adapter


        nextFragmentButton.setOnClickListener {
            nextFragmentButton.isActivated= true
            prevFragmentButton.isActivated = true
            viewPager.currentItem = 0
        }


        return view
    }

}


