package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.databinding.CardViewFavouriteBinding

class FavouriteScreenAdapter: RecyclerView.Adapter<FavouriteScreenAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_favourite, parent, false)
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = CardViewFavouriteBinding.bind(itemView)
        private val context: Context = itemView.context

        @RequiresApi(Build.VERSION_CODES.P)
        fun bind(item: List<String>) {
            if (item.isNotEmpty()){
            binding.apply {
                recipeText.text = item[0]
                minutesText.text = item[1].plus(" Min")
                Glide.with(context)
                    .load(item[2])
                    .placeholder(R.drawable.loading)
                    .centerCrop()
                    .into(binding.itemImage)
                drawableFavorite.setOnClickListener {
                    val position = absoluteAdapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        removeItem(position)
                    }

                }

            }
        }
//            else binding.apply {
//                val emptyFavScreen = itemView.requireViewById<View>(R.id.empty_fav)
//                emptyFavScreen.visibility = View.VISIBLE
//                emptyFavScreen.layoutParams = RecyclerView.LayoutParams(0, 0)
//            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<List<String>>() {
        override fun areItemsTheSame(oldItem: List<String>, newItem: List<String>): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: List<String>, newItem: List<String>): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)
    private fun removeItem(index : Int) {
        val newList = ArrayList(differ.currentList)
        newList.removeAt(index)
        differ.submitList(newList)
    }


}