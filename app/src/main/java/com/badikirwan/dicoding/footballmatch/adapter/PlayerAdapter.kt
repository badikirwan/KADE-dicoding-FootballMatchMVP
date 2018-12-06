package com.badikirwan.dicoding.footballmatch.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.model.Player
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.player_item.*

class PlayerAdapter(private val player: List<Player>,
                    private val listener: (Player) -> Unit): RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int)  =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.player_item, parent, false
            )
        )
    override fun getItemCount() = player.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(player[position], listener)
    }

    class ViewHolder(override val containerView: View):
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindItem(player: Player, listener: (Player) -> Unit) {
            tv_player.text = player.strPlayer
            tv_position.text = player.strPosition
            Glide.with(itemView.context).load(player.strCutout).into(iv_player)

            containerView.setOnClickListener { listener(player) }
        }

    }
}