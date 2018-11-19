package com.badikirwan.dicoding.footballmatch.view.lastmatch

import com.badikirwan.dicoding.footballmatch.model.EventItem

interface LastMatchView {

    fun showLoading()
    fun hideLoading()
    fun showMatchEvent(eventItem: List<EventItem>)
}