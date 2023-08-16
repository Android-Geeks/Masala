package com.example.masala_food_recipes
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class DetailsScreen : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var nextFragmentButton: Button
    private lateinit var prevFragmentButton: Button
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

        return inflater.inflate(R.layout.fragment_details_screen, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nextFragmentButton = view.findViewById(R.id.button_2)
        prevFragmentButton = view.findViewById(R.id.button_1)
        viewpager=requireActivity().findViewById(R.id.viewpager)

        nextFragmentButton.setOnClickListener {
            nextFragmentButton.isActivated = false
            prevFragmentButton.isActivated = false
            viewpager.currentItem = 0
        }

        prevFragmentButton.setOnClickListener {
            nextFragmentButton.isActivated = true
            prevFragmentButton.isActivated = true
            viewpager.currentItem = 1
        }
    }


}

