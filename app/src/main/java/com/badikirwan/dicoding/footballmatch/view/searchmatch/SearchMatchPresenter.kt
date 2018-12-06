package com.badikirwan.dicoding.footballmatch.view.searchmatch

import com.badikirwan.dicoding.footballmatch.api.ApiRepository
import com.badikirwan.dicoding.footballmatch.api.TheSportDBApi
import com.badikirwan.dicoding.footballmatch.model.EventItemResponse
import com.badikirwan.dicoding.footballmatch.util.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchMatchPresenter(private val view: SearchMatchView,
                           private val apiRepository: ApiRepository,
                           private val gson: Gson,
                           private val context: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun getSearchMatch(query: String?) {
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getSearchMatch(query)).await(),
                EventItemResponse::class.java)

            view.hideLoading()
            view.showSearchMatch(data.events)
        }
    }

}