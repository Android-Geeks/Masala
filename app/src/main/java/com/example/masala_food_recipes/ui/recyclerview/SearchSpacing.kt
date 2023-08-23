package com.example.masala_food_recipes.ui.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemsPaddingDecoration(
    private val padding : Int , private val lastItem :Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect : Rect , view : View , parent : RecyclerView , state : RecyclerView.State
    ) {
        super.getItemOffsets(outRect , view , parent , state)
        val position = parent.getChildAdapterPosition(view)
        if (position == 0) {
            outRect.top = padding + 16
        }
        if(position == lastItem){
            outRect.bottom=padding + 8
        }
    }
}