package com.example.masala_food_recipes.ui.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface BaseInteractionListener          // an listener to be modified as needed

abstract class BaseRecyclerAdapter<T, VH : BaseRecyclerAdapter.BaseViewHolder<T>>(
    val items: List<T>, private val listener : BaseInteractionListener
) : RecyclerView.Adapter<VH>() {

    abstract val layoutId: Int                   // The ID of the layout to be worked on

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return createViewHolder(LayoutInflater.from(parent.context).inflate(layoutId, parent, false))
    }

    abstract fun createViewHolder(view: View): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])

    }

    abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

        abstract fun bind(item: T)
    }

    override fun getItemCount(): Int = items.size
}


/* -------------------An example of its use----------------

class MatchAdapter(items: List<Match>, listener: interact):BaseRecyclerAdapter<Match, BaseRecyclerAdapter.BaseViewHolder<Match>>(items,listener) {

    override val layoutId: Int = R.layout.recycler_item

    override fun createViewHolder(view: View): BaseViewHolder<Match> = MatchViewHolder(view)

    class MatchViewHolder(itemView: View): BaseViewHolder<Match>(itemView) {
        private val binding = RecyclerItemBinding.bind(itemView)

        override fun bind(item: Match) {
            binding.apply {
                homeTeam.text = item.homeTeam
                homeTeamGoal.text = item.homeTeamGoal
                awayTeam.text = item.awayTeam
                awayTeamGoal.text = item.awayTeamGoal

            }

        }
    }
}*/
