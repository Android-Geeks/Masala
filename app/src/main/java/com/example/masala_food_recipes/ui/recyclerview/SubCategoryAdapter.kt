package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.view.View
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.databinding.Under20MinBinding

class SubCategoryAdapter(
        items : List<List<String>> ,
        listener : BaseInteractionListener ,
        val sharedPref : SharedPreferences
) : BaseRecyclerAdapter<List<String> , BaseRecyclerAdapter.BaseViewHolder<List<String>>>(
        items , listener) {

    override val layoutId : Int = R.layout.under_20_min
    val favouriteSet = sharedPref.getStringSet("Favourite" , emptySet())?.toMutableSet()

    override fun createViewHolder(view : View) : BaseViewHolder<List<String>> =
            RecipeViewHolder(view)

    inner class RecipeViewHolder(itemView : View) : BaseViewHolder<List<String>>(itemView) {
        private val binding = Under20MinBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        override fun bind(item : List<String>) {
            binding.apply {
                reciepeName.text = item[0]
                time.text = "${item[1]} min "
                Glide.with(itemView).load(item[2]).placeholder(R.drawable.loading).into(image)
                favouriteCheckBox.apply {
                    setOnCheckedChangeListener{_,isChecked ->
                        if(isChecked) favouriteSet?.add(item[0])
                        else favouriteSet?.remove(item[0])
                        sharedPref.edit().putStringSet("Favourite",favouriteSet).apply()
                    }
                    isChecked=favouriteSet?.contains(item[0]) == true
                }
            }
        }
    }
}