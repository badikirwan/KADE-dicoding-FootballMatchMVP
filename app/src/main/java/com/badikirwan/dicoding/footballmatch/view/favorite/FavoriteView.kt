package com.badikirwan.dicoding.footballmatch.view.favorite

import com.badikirwan.dicoding.footballmatch.model.EventItem
import com.badikirwan.dicoding.footballmatch.model.Team

interface FavoriteView {

    fun showLoading()
    fun hideLoading()
    fun showEmptyData()
    fun showFavoriteEvent(eventItem: List<EventItem>)
    fun showFavoriteTeam(team: List<Team>)
}