package com.badikirwan.dicoding.footballmatch.view.favorite

import android.content.Context
import com.badikirwan.dicoding.footballmatch.db.database
import com.badikirwan.dicoding.footballmatch.model.EventItem
import com.badikirwan.dicoding.footballmatch.model.Team
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class FavoritePresenter(private val view: FavoriteView) {

    fun getFavoriteEvent(context: Context) {
        view.showLoading()
        val eventItem: MutableList<EventItem> = mutableListOf()

        context.database.use {
            val result = select(EventItem.TABLE_FAVORITES)
            val favorite = result.parseList(classParser<EventItem>())
            eventItem.addAll(favorite)
        }

        view.hideLoading()

        if (eventItem.isEmpty()) {
            view.showEmptyData()
        } else {
            view.showFavoriteEvent(eventItem)
        }
    }

    fun getFavoriteTeam(context: Context) {
        view.showLoading()
        val team: MutableList<Team> = mutableListOf()

        context.database.use {
            val result = select(Team.TABLE_TEAMS)
            val favorite = result.parseList(classParser<Team>())
            team.addAll(favorite)
        }

        view.hideLoading()

        if (team.isEmpty()) {
            view.showEmptyData()
        } else {
            view.showFavoriteTeam(team)
        }
    }
}