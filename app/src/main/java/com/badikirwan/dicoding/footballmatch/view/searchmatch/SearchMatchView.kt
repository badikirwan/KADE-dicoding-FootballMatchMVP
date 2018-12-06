package com.badikirwan.dicoding.footballmatch.view.searchmatch

import com.badikirwan.dicoding.footballmatch.model.EventItem

interface SearchMatchView {
    fun showLoading()
    fun hideLoading()
    fun showSearchMatch(data: List<EventItem>)
}