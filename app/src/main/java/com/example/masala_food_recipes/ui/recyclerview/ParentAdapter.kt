package com.example.masala_food_recipes.ui.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.masala_food_recipes.ChildItem
import com.example.masala_food_recipes.ParentItem
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.databinding.ParentItemBinding

class ParentAdapter(
    private val context: Context,
    private val parentList: List<ParentItem>,
    private val childList: List<ChildItem>
) : RecyclerView.Adapter<ParentAdapter.PViewHolder>() {

    private val recipeList = DataManager(context).getAllRecipesData()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PViewHolder {
        return PViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PViewHolder, position: Int) {
        val parentItem = parentList[position]
        holder.binding.headerText.text = parentItem.type
//        holder.binding.appName.visibility = View.GONE

        val childItem = childList[position]
        holder.binding.parentRecycler.adapter =
            ChildAdapter(context, childList, recipeList)
    }

    override fun getItemCount(): Int = parentList.size

    class PViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ParentItemBinding.bind(itemView)
    }
}