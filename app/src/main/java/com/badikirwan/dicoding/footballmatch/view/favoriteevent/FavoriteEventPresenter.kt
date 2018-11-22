package com.badikirwan.dicoding.footballmatch.view.favoriteevent

import android.content.Context
import com.badikirwan.dicoding.footballmatch.db.database
import com.badikirwan.dicoding.footballmatch.model.EventItem
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class FavoriteEventPresenter(private val view: FavoriteEventView) {

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
}