package com.badikirwan.dicoding.footballmatch.view.detail

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import com.badikirwan.dicoding.footballmatch.api.ApiRepository
import com.badikirwan.dicoding.footballmatch.api.TheSportDBApi
import com.badikirwan.dicoding.footballmatch.db.database
import com.badikirwan.dicoding.footballmatch.model.EventItem
import com.badikirwan.dicoding.footballmatch.model.TeamResponse
import com.badikirwan.dicoding.footballmatch.util.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

class DetailActivityPresenter(private val view: DetailActivityView,
                              private val apiRepository: ApiRepository,
                              private val gson: Gson,
                              private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getImageHomeTeam(idHomeTeam: String?) {
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getImageTeam(idHomeTeam)).await(),
                TeamResponse::class.java)

            view.showImageHomeTeam(data.teams)
        }
    }

    fun getImageAwayeTeam(idAwayTeam: String?) {
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getImageTeam(idAwayTeam)).await(),
                TeamResponse::class.java)

            view.showImageAwayTeam(data.teams)
        }
    }

    fun favoriteState(context: Context, eventItem: EventItem) : Boolean {
        var isFavorite = false
        context.database.use {
            val result = select(EventItem.TABLE_FAVORITES)
                .whereArgs(EventItem.ID_EVENT + " = {id}",
                    "id" to eventItem.idEvent.toString())
            val favorite = result.parseList(classParser<EventItem>())
            isFavorite = !favorite.isEmpty()
        }
        return isFavorite
    }

    fun addToFavorite(context: Context, eventItem: EventItem) {
        try {
            context.database.use {
                insert(EventItem.TABLE_FAVORITES,
                    EventItem.ID_EVENT to eventItem.idEvent,
                    EventItem.DATE to eventItem.dateEvent,
                    EventItem.HOME_ID to eventItem.idHomeTeam,
                    EventItem.HOME_TEAM to eventItem.strHomeTeam,
                    EventItem.HOME_SCORE to eventItem.intHomeScore,
                    EventItem.HOME_FORMATION to eventItem.strHomeFormation,
                    EventItem.HOME_GOAL_DETAILS to eventItem.strHomeGoalDetails,
                    EventItem.HOME_SHOTS to eventItem.intHomeShots,
                    EventItem.HOME_LINEUP_GOALKEEPER to eventItem.strHomeLineupGoalkeeper,
                    EventItem.HOME_LINEUP_DEFENSE to eventItem.strHomeLineupDefense,
                    EventItem.HOME_LINEUP_MIDFIELD to eventItem.strHomeLineupMidfield,
                    EventItem.HOME_LINEUP_FORWARD to eventItem.strHomeLineupForward,
                    EventItem.HOME_LINEUP_SUBSTITUTES to eventItem.strHomeLineupSubstitutes,
                    EventItem.AWAY_ID to eventItem.idAwayTeam,
                    EventItem.AWAY_TEAM to eventItem.strAwayTeam,
                    EventItem.AWAY_SCORE to eventItem.intAwayScore,
                    EventItem.AWAY_FORMATION to eventItem.strAwayFormation,
                    EventItem.AWAY_GOAL_DETAILS to eventItem.strAwayGoalDetails,
                    EventItem.AWAY_SHOTS to eventItem.intAwayShots,
                    EventItem.AWAY_LINEUP_GOALKEEPER to eventItem.strAwayLineupGoalkeeper,
                    EventItem.AWAY_LINEUP_DEFENSE to eventItem.strAwayLineupDefense,
                    EventItem.AWAY_LINEUP_MIDFIELD to eventItem.strAwayLineupMidfield,
                    EventItem.AWAY_LINEUP_FORWARD to eventItem.strAwayLineupForward,
                    EventItem.AWAY_LINEUP_SUBSTITUTES to eventItem.strAwayLineupSubstitutes)
            }
        } catch (e: SQLiteConstraintException) {
            Log.e("errornya", "${e.message}")
        }
    }

    fun removeFromFavorite(context: Context, eventItem: EventItem) {
        try {
            context.database.use {
                delete(EventItem.TABLE_FAVORITES,
                    EventItem.ID_EVENT + " = {id}", "id" to eventItem.idEvent.toString())
            }
        } catch (e: SQLiteConstraintException) {
            Log.e("Error:", "${e.message}")
        }
    }

}