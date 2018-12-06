package com.badikirwan.dicoding.footballmatch.view.team

import com.badikirwan.dicoding.footballmatch.model.League
import com.badikirwan.dicoding.footballmatch.model.LeagueResponse
import com.badikirwan.dicoding.footballmatch.model.Team

interface TeamView {

    fun showLoading()
    fun hideLoading()
    fun showListTeam(data: List<Team>)
    fun showListLeague(data: LeagueResponse)
    fun showTeamSearch(data: List<Team>)
}