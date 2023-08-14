package com.example.masala_food_recipes.ui.recyclerview

import android.view.View
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.databinding.Under20MinBinding

class SubCategoryAdapter(items : List<List<String>> , listener : BaseInteractionListener?) :
    BaseRecyclerAdapter<List<String> , BaseRecyclerAdapter.BaseViewHolder<List<String>>>(
        items , listener
    ) {

    override val layoutId : Int = R.layout.under_20_min

    override fun createViewHolder(view : View) : BaseViewHolder<List<String>> =
            RecipeViewHolder(view)

    class RecipeViewHolder(itemView : View) : BaseViewHolder<List<String>>(itemView) {
        private val binding = Under20MinBinding.bind(itemView)

        override fun bind(item : List<String>) {
            binding.apply {
                reciepeName.text = item[0]
                "${item[1]} min".also { time.text = it }
                Glide.with(itemView)
                        .load(item[2])
                        .into(image)
            }
        }
    }
}