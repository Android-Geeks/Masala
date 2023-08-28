package com.example.masala_food_recipes.ui.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class FirstItemPaddingDecoration(
        private val padding : Int , private val lastItem :Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
            outRect : Rect , view : View , parent : RecyclerView , state : RecyclerView.State
    ) {
        super.getItemOffsets(outRect , view , parent , state)
        val position = parent.getChildAdapterPosition(view)
        if (position == 0) {
            outRect.left = padding + 16
        }
        if(position == lastItem){
            outRect.right=padding + 8
        }
    }
}

class CuisineDetailsItemPadding(
    private val padding : Int , private val lastItem :Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect : Rect , view : View , parent : RecyclerView , state : RecyclerView.State
    ) {
        super.getItemOffsets(outRect , view , parent , state)
        val position = parent.getChildAdapterPosition(view)
            outRect.left = padding + 16
            outRect.right = padding + 16
            outRect.bottom = padding + 16


//        if(position == lastItem){
//            outRect.right=padding + 8
//        }
    }
}