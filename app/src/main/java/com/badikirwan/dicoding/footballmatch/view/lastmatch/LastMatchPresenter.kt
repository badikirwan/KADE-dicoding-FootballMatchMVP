package com.badikirwan.dicoding.footballmatch.view.lastmatch

import android.util.Log
import com.badikirwan.dicoding.footballmatch.api.ApiClient
import com.badikirwan.dicoding.footballmatch.model.EventItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LastMatchPresenter(private val viewLast: LastMatchView,
                         private val apiClient: ApiClient) {

    fun getEventLastMatch(id: String) {
        viewLast.showLoading()
        apiClient.create().getPastMatch(id).enqueue(object : Callback<EventItemResponse> {

            override fun onFailure(call: Call<EventItemResponse>, t: Throwable) {
                Log.e("Errornya :", "${t.message}")
                viewLast.hideLoading()
            }

            override fun onResponse(call: Call<EventItemResponse>, response: Response<EventItemResponse>) {
                if (response.isSuccessful) {
                    viewLast.showMatchEvent(response.body()?.events!!)
                }
                viewLast.hideLoading()
            }
        })
    }
}