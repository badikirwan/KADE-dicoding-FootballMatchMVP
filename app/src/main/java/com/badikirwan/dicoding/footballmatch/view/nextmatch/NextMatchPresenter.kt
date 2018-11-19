package com.badikirwan.dicoding.footballmatch.view.nextmatch

import android.util.Log
import com.badikirwan.dicoding.footballmatch.api.ApiClient
import com.badikirwan.dicoding.footballmatch.model.EventItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NextMatchPresenter(private val view: NextMatchView,
                         private val apiClinet: ApiClient) {

    fun getNextEventMatch(id: String) {
        view.showLoading()
        apiClinet.create().getNextMatch(id).enqueue(object : Callback<EventItemResponse> {

            override fun onFailure(call: Call<EventItemResponse>, t: Throwable) {
                Log.e("Errornya :", "${t.message}")
                view.hideLoading()
            }

            override fun onResponse(call: Call<EventItemResponse>, response: Response<EventItemResponse>) {
                if (response.isSuccessful) {
                    view.showNextEventMatch(response.body()?.events!!)
                    view.hideLoading()
                }
            }

        })

    }
}