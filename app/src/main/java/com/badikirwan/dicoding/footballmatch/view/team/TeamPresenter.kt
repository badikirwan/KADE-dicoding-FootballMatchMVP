package com.badikirwan.dicoding.footballmatch.view.team

import com.badikirwan.dicoding.footballmatch.api.ApiRepository
import com.badikirwan.dicoding.footballmatch.api.TheSportDBApi
import com.badikirwan.dicoding.footballmatch.model.LeagueResponse
import com.badikirwan.dicoding.footballmatch.model.TeamResponse
import com.badikirwan.dicoding.footballmatch.util.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TeamPresenter(private val view: TeamView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson,
                    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun getTeams(league: String) {
        view.showLoading()
        GlobalScope.launch(context.main){
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getAllTeam(league)).await(),
                TeamResponse::class.java)

            view.hideLoading()
            view.showListTeam(data.teams)
        }
    }

    fun getSearchTeam(query: String?) {
        view.showLoading()
        GlobalScope.launch(context.main){
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getSearchTeam(query)).await(),
                TeamResponse::class.java)

            view.hideLoading()
            view.showTeamSearch(data.teams)
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