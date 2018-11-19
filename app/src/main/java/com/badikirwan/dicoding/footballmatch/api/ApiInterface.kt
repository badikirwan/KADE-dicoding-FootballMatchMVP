package com.badikirwan.dicoding.footballmatch.api

import com.badikirwan.dicoding.footballmatch.model.EventItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("eventsnextleague.php")
    fun getNextMatch(@Query("id") id: String?): Call<EventItemResponse>

    @GET("eventspastleague.php")
    fun getPastMatch(@Query("id") id: String?): Call<EventItemResponse>

}