package com.example.masala_food_recipes.ui.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.masala_food_recipes.R

class IngredientDetailsAdapter(private val itemList: List<String>) :
    RecyclerView.Adapter<IngredientDetailsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemText: TextView = itemView.findViewById(R.id.item_text)
        val numberText: TextView = itemView.findViewById(R.id.numberText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ingredient_details, parent, false)
        return ViewHolder(view)
    }

    @Suppress("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.numberText.text = "${position + 1}"
        holder.itemText.text = item
    }

    override fun getItemCount() = itemList.size
}