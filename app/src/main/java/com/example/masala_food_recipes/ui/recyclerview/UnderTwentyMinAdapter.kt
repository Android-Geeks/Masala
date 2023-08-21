package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.databinding.CardViewSubCategoryBinding

interface UnderTwentyMinListener : BaseInteractionListener
class UnderTwentyMinAdapter(items: List<List<String>>,listener: UnderTwentyMinListener) :BaseRecyclerAdapter<List<String>,BaseRecyclerAdapter.BaseViewHolder<List<String>>>(items, listener) {
    override val layoutId = R.layout.card_view_sub_category

    override fun createViewHolder(view: View): BaseViewHolder<List<String>> = UnderTwentyViewHolder(view)

    class UnderTwentyViewHolder(itemView: View) : BaseViewHolder<List<String>>(itemView) {
        private val binding = CardViewSubCategoryBinding.bind(itemView)
        private val context: Context = itemView.context

        @SuppressLint("SetTextI18n")
        override fun bind(item: List<String>) {

            if (item.isNotEmpty()) {
                binding.apply {
                    textViewRecipe.text = "${item[0]} min"
                    minutesText.text = "${item[1]} min"
                    Glide.with(context)
                        .load(item[2])
                        .centerCrop()
                        .into(recipeImage)
                }
            }
            else{
                itemView.visibility = View.GONE
                itemView.layoutParams = RecyclerView.LayoutParams(0, 0)
            }
        }
    }}