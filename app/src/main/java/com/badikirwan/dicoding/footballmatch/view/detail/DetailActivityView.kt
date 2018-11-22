package com.badikirwan.dicoding.footballmatch.view.detail

import com.badikirwan.dicoding.footballmatch.model.Team

interface DetailActivityView {

    fun showImageHomeTeam(homeTeam: List<Team>)
    fun showImageAwayTeam(awayTeam: List<Team>)
}