package com.badikirwan.dicoding.footballmatch.view.teamdetails.players

import com.badikirwan.dicoding.footballmatch.model.Player

interface PlayerView {

    fun showLoading()
    fun hideLoading()
    fun showPlayerTeam(data: List<Player>)
}