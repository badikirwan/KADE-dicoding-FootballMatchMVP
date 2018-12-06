package com.badikirwan.dicoding.footballmatch.view.lastmatch

import com.badikirwan.dicoding.footballmatch.model.EventItem
import com.badikirwan.dicoding.footballmatch.model.LeagueResponse

interface LastMatchView {

    fun showLoading()
    fun hideLoading()
    fun showMatchEvent(eventItem: List<EventItem>)
    fun showListLeague(data: LeagueResponse)
}