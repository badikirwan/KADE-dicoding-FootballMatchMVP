package com.badikirwan.dicoding.footballmatch.view.match.nextmatch

import com.badikirwan.dicoding.footballmatch.model.EventItem
import com.badikirwan.dicoding.footballmatch.model.LeagueResponse

interface NextMatchView {

    fun showLoading()
    fun hideLoading()
    fun showNextEventMatch(eventItem: List<EventItem>)
    fun showListLeague(data: LeagueResponse)
}