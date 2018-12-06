package com.badikirwan.dicoding.footballmatch.view.lastmatch

import com.badikirwan.dicoding.footballmatch.api.ApiRepository
import com.badikirwan.dicoding.footballmatch.api.TheSportDBApi
import com.badikirwan.dicoding.footballmatch.model.EventItemResponse
import com.badikirwan.dicoding.footballmatch.model.LeagueResponse
import com.badikirwan.dicoding.footballmatch.util.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LastMatchPresenter(private val viewLast: LastMatchView,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson,
                         private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getEventLastMatch(id: String) {
        viewLast.showLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getPastMatch(id)).await(),
                EventItemResponse::class.java)

            viewLast.hideLoading()
            viewLast.showMatchEvent(data.events)
        }
    }

    fun getLeague() {
        viewLast.showLoading()
        GlobalScope.launch(context.main){
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getLeague()).await(),
                LeagueResponse::class.java)

            viewLast.hideLoading()
            viewLast.showListLeague(data)
        }
    }
}