package com.badikirwan.dicoding.footballmatch.view.favoriteevent

import com.badikirwan.dicoding.footballmatch.model.EventItem

interface FavoriteEventView {

    fun showLoading()
    fun hideLoading()
    fun showEmptyData()
    fun showFavoriteEvent(eventItem: List<EventItem>)
}