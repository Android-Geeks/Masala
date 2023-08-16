package com.example.masala_food_recipes.ui.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.Recipe

class RecyclerViewAdapter1( private val itemList: List<Recipe>) :
    RecyclerView.Adapter<RecyclerViewAdapter1.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemText: TextView = itemView.findViewById(R.id.itemText)
        val numberText: TextView = itemView.findViewById(R.id.numberText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_1, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.numberText.text = item.ingredientCount
        holder.itemText.text = item.translatedIngredients.toString()

    }

    override fun getItemCount(): Int = itemList.size
}