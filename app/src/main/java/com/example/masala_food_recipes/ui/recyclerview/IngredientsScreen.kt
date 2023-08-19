package com.example.masala_food_recipes.ui.recyclerview
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.databinding.FragmentIngredientsScreenBinding
import com.example.masala_food_recipes.ui.fragment.BaseFragment

class IngredientsScreen : BaseFragment<FragmentIngredientsScreenBinding>(FragmentIngredientsScreenBinding::inflate) {


    override fun onCreateView() {
        val dataList = DataManager(requireContext()).getAllRecipesData()
       val  recyclerView = binding.recyclerView1

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.recyclerView1.adapter= RecyclerViewAdapter1(dataList)
    }


}



