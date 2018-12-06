package com.badikirwan.dicoding.footballmatch.view.searchmatch

import com.badikirwan.dicoding.footballmatch.model.EventItem
import com.badikirwan.dicoding.footballmatch.model.Team

interface SearchMatchView {
    fun showLoading()
    fun hideLoading()
    fun showSearchMatch(data: List<EventItem>)
}