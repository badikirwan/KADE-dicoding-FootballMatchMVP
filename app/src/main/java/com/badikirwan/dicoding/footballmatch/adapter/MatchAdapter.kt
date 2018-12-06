package com.badikirwan.dicoding.footballmatch.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.model.EventItem
import com.badikirwan.dicoding.footballmatch.util.ConvertDateEvent
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.match_item.*

class MatchAdapter(private val items: List<EventItem>,
                   private val listener: (EventItem) -> Unit) : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.match_item, parent, false
            )
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindItem(items[position], listener)
    }

    class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindItem(items: EventItem, listener: (EventItem) -> Unit) {
            match_item_date.text = ConvertDateEvent.getFormatDate(items.dateEvent!!)
            match_item_home.text = items.strHomeTeam
            match_item_away.text = items.strAwayTeam
            match_item_home_score.text = items.intHomeScore
            match_item_away_score.text = items.intAwayScore

            containerView.setOnClickListener { listener(items) }
        }
    }
}