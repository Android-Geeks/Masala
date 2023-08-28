package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.telecom.Call.Details
import android.view.View
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.databinding.Under20MinBinding
import com.example.masala_food_recipes.ui.fragment.CuisineDetailsFragmentDirections

interface CuisineDetailsListener : BaseInteractionListener

class CuisineDetailsAdapter(items: List<List<String>>, listener: CuisineDetailsListener) :
    BaseRecyclerAdapter<List<String>, BaseRecyclerAdapter.BaseViewHolder<List<String>>>(
        items,
        listener
    ) {
    override val layoutId = R.layout.under_20_min

    override fun createViewHolder(view: View): BaseViewHolder<List<String>>  = CDViewHolder(view)

    inner class CDViewHolder(itemView: View): BaseViewHolder<List<String>>(itemView) {
        private val binding = Under20MinBinding.bind(itemView)
        private val context: Context = itemView.context


        @SuppressLint("SetTextI18n")
        override fun bind(item: List<String>) {
            binding.apply {
                reciepeName.text = item[0]
                time.text = "${item[1]} min"

                Glide.with(context)
                    .load(item[2])
                    .centerCrop()
                    .placeholder(R.drawable.loading)
                    .into(image)
                image.setOnClickListener{
//                    val action = CuisineDetailsFragmentDirections.actionCuisineDetailsFragmentToDetailsScreen(Details())
                    Navigation.findNavController(it).navigate(R.id.action_cuisineDetailsFragment_to_detailsFragment)
                }
            }
        }
    }
}
/*                recipeImage.setOnClickListener {

    val action = HomeFragmentDirections.actionHomeFragmentToFragmentDetailsScreen(
            Details(allRecipes).findRecipe(item[0]))
    Navigation.findNavController(it).navigate(action)
}*/