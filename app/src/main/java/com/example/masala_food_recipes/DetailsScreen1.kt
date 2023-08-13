package com.example.masala_food_recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.interactors.RecyclerViewAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class DetailsScreen1 : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewPager: ViewPager2
    private lateinit var nextFragmentButton: Button
    private lateinit var prevFragmentButton: Button
    private lateinit var adapter: RecyclerViewAdapter
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

        val view = inflater.inflate(R.layout.fragment_details_screen1, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        viewPager = requireActivity().findViewById(R.id.viewPager)
        nextFragmentButton = view.findViewById(R.id.button_2)
        prevFragmentButton = view.findViewById(R.id.button_1)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val dataList = DataManager(requireContext()).getAllRecipesData()
        val adapter = RecyclerViewAdapter(dataList)
        recyclerView.adapter = adapter



        nextFragmentButton.setOnClickListener {

            nextFragmentButton.isActivated = false
            prevFragmentButton.isActivated = false
            viewPager.currentItem = 1

        }

        return view
    }

}


