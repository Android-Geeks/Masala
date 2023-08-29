package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.view.View
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.util.FavouritePreferences
import com.example.masala_food_recipes.databinding.Under20MinBinding

class SubCategoryAdapter(
    items: List<List<String>>, private val isForYou: Boolean = false
) : BaseRecyclerAdapter<List<String>, BaseRecyclerAdapter.BaseViewHolder<List<String>>>(
    items
) {

    override val layoutId: Int = R.layout.under_20_min

    override fun createViewHolder(view: View): BaseViewHolder<List<String>> =
        RecipeViewHolder(view)

    inner class RecipeViewHolder(itemView: View) : BaseViewHolder<List<String>>(itemView) {
        private val binding = Under20MinBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        override fun bind(item: List<String>) {
            binding.apply {
                reciepeName.text = item[0]
                if (isForYou)
                    time.text = "${item[3]} min"
                else
                    time.text = "${item[1]} min"
                Glide.with(itemView).load(item[2]).placeholder(R.drawable.loading).into(image)
                favouriteCheckBox.apply {
                    setOnCheckedChangeListener { _, isChecked ->
                        val favouriteSet = FavouritePreferences.getFromSharedPref()
                        if (isChecked) favouriteSet?.add(item[0])
                        else favouriteSet?.remove(item[0])
                        FavouritePreferences.putInSharedPref(favouriteSet!!)
                    }
                    this.isChecked =
                        FavouritePreferences.getFromSharedPref()?.contains(item[0]) == true
                }

            }

        }
    }
}