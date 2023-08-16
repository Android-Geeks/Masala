package com.example.masala_food_recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.requireViewById
import androidx.viewpager2.widget.ViewPager2


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ContainerDetails : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val fragments = listOf(DetailsScreen1(), DetailsScreen2())
    private lateinit var viewpager : ViewPager2
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
        val view =  inflater.inflate(R.layout.fragment_container_details, container, false)




      val transaction =childFragmentManager.beginTransaction()
        transaction.add(R.id.details_screen,DetailsScreen())
        transaction.addToBackStack(null)
        transaction.commit()




    val adapter = PagerAdapter(this, fragments)
    viewpager =view.findViewById(R.id.viewpager)
    viewpager.adapter = adapter

        return view
}}