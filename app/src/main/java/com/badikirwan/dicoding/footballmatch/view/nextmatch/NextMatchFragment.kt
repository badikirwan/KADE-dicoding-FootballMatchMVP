package com.badikirwan.dicoding.footballmatch.view.nextmatch


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter

import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.adapter.MatchAdapter
import com.badikirwan.dicoding.footballmatch.api.ApiRepository
import com.badikirwan.dicoding.footballmatch.model.EventItem
import com.badikirwan.dicoding.footballmatch.model.League
import com.badikirwan.dicoding.footballmatch.model.LeagueResponse
import com.badikirwan.dicoding.footballmatch.view.detail.DetailActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_next_match.*

class NextMatchFragment : Fragment(), NextMatchView {

    private val data: MutableList<EventItem> = mutableListOf()
    private lateinit var league: League
    private lateinit var presenter: NextMatchPresenter
    private lateinit var adapter: MatchAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_next_match, container, false)
        recyclerView = view.findViewById(R.id.recycle_next_match)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        presenter = NextMatchPresenter(this, ApiRepository(), Gson())
        adapter = MatchAdapter(data) { eventItem ->
            startActivity(context?.let { DetailActivity.newIntent(it, eventItem) })
        }
        recyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.getLeague()
    }

    override fun showLoading() {
        prog_next_match.visibility = View.VISIBLE
        recycle_next_match.visibility = View.INVISIBLE
    }

    override fun hideLoading() {
        prog_next_match.visibility = View.INVISIBLE
        recycle_next_match.visibility = View.VISIBLE
    }

    override fun showNextEventMatch(eventItem: List<EventItem>) {
        data.clear()
        data.addAll(eventItem)
        adapter.notifyDataSetChanged()
    }

    override fun showListLeague(data: LeagueResponse) {
        spinner.adapter = ArrayAdapter(context, R.layout.support_simple_spinner_dropdown_item, data.league)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                league = spinner.selectedItem as League
                presenter.getNextEventMatch(league.idLeague.toString())
            }

        }
    }
}
