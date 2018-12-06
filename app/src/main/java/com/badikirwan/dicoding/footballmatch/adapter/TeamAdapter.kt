package com.badikirwan.dicoding.footballmatch.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.model.Team
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.teams_item.*

class TeamAdapter(private val teams: List<Team>,
                  private val listener: (Team) -> Unit): RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.teams_item, parent, false
            )
        )

    override fun getItemCount() = teams.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(teams[position], listener)
    }

    class ViewHolder(override val containerView: View):
        RecyclerView.ViewHolder(containerView), LayoutContainer  {

        fun bindItem(teams: Team, listener: (Team) -> Unit) {
            team_name.text = teams.strTeam
            Glide.with(itemView.context).load(teams.strTeamBadge).into(team_badge)

            containerView.setOnClickListener { listener(teams) }
        }
    }
}