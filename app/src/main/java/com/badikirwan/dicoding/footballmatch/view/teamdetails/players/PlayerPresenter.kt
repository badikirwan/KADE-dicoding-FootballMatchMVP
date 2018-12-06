package com.badikirwan.dicoding.footballmatch.view.teamdetails.players

import com.badikirwan.dicoding.footballmatch.api.ApiRepository
import com.badikirwan.dicoding.footballmatch.api.TheSportDBApi
import com.badikirwan.dicoding.footballmatch.model.PlayerResponse
import com.badikirwan.dicoding.footballmatch.util.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PlayerPresenter(private val view: PlayerView,
                      private val apiRepository: ApiRepository,
                      private val gson: Gson,
                      private val context: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun getPlayerTeam(id: String?) {
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getPlayerTeam(id)).await(),
                PlayerResponse::class.java)

            view.hideLoading()
            view.showPlayerTeam(data.player)

        }
    }
}