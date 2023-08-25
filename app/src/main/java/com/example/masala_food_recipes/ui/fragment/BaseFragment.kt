package com.example.masala_food_recipes.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(
    private val bindingInflater: (inflater: LayoutInflater) -> VB
) : Fragment() {
    private lateinit var _binding: VB
    protected val binding: VB
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater(inflater)
        onCreateView()
        return binding.root
    }

    abstract fun onCreateView()

    fun navTo(direction : String, v : View, id : Int?){
        if (direction == "forward"){
            Navigation.findNavController(v).navigate(id!!)
        }
        else if (direction =="back") {
            Navigation.findNavController(v).popBackStack()
        }

    }
}
