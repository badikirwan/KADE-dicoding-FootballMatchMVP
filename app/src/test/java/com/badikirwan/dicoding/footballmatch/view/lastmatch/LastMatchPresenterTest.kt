package com.badikirwan.dicoding.footballmatch.view.lastmatch

import com.badikirwan.dicoding.footballmatch.api.ApiRepository
import com.badikirwan.dicoding.footballmatch.api.TheSportDBApi
import com.badikirwan.dicoding.footballmatch.model.EventItem
import com.badikirwan.dicoding.footballmatch.model.EventItemResponse
import com.badikirwan.dicoding.footballmatch.util.TestContextProvider
import com.google.gson.Gson
import com.nhaarman.mockito_kotlin.verify
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test

import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class LastMatchPresenterTest {

    private lateinit var presenter: LastMatchPresenter

    @Mock
    private lateinit var view: LastMatchView
    @Mock
    private lateinit var apiRepository: ApiRepository
    @Mock
    private lateinit var gson: Gson

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = LastMatchPresenter(view, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun `menggambil data last match event`() {
        val event: MutableList<EventItem> = mutableListOf()
        val response =  EventItemResponse(event)
        val id = "4328"

        GlobalScope.launch {
            `when`(gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getPastMatch(id)).await(),
                EventItemResponse::class.java
            )).thenReturn(response)

            presenter.getEventLastMatch(id)

            verify(view).showLoading()
            verify(view).showMatchEvent(event)
            verify(view).hideLoading()
        }

    }
}