package com.badikirwan.dicoding.footballmatch.view.nextmatch

import com.badikirwan.dicoding.footballmatch.model.EventItem

interface NextMatchView {

    fun showLoading()
    fun hideLoading()
    fun showNextEventMatch(eventItem: List<EventItem>)
}