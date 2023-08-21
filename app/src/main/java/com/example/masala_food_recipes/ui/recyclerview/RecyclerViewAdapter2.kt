package com.example.masala_food_recipes.ui.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.masala_food_recipes.R

class RecyclerViewAdapter2(private val itemList: List<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemText: TextView = itemView.findViewById(R.id.item_text)
        val numberText: TextView = itemView.findViewById(R.id.number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_2, parent, false)
        return ViewHolder(view)
    }

    @Suppress("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.numberText.text = "${position + 1}. "

        if (item[0] == '\n') {
            holder.itemText.text = item.substring(1)
        } else {
            holder.itemText.text = item
        }
    }

    override fun getItemCount() = itemList.size
}