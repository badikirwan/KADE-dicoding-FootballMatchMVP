package com.badikirwan.dicoding.footballmatch.view.nextmatch

import com.badikirwan.dicoding.footballmatch.api.ApiRepository
import com.badikirwan.dicoding.footballmatch.api.TheSportDBApi
import com.badikirwan.dicoding.footballmatch.model.EventItemResponse
import com.badikirwan.dicoding.footballmatch.model.LeagueResponse
import com.badikirwan.dicoding.footballmatch.util.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NextMatchPresenter(private val view: NextMatchView,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson,
                         private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getNextEventMatch(id: String) {
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getNextMatch(id)).await(),
                EventItemResponse::class.java)

            view.hideLoading()
            view.showNextEventMatch(data.events)
        }
    }

    fun getLeague() {
        view.showLoading()
        GlobalScope.launch(context.main){
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getLeague()).await(),
                LeagueResponse::class.java)

            view.hideLoading()
            view.showListLeague(data)
        }
    }

}