package com.badikirwan.dicoding.footballmatch.view.team


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView

import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.adapter.TeamAdapter
import com.badikirwan.dicoding.footballmatch.api.ApiRepository
import com.badikirwan.dicoding.footballmatch.model.League
import com.badikirwan.dicoding.footballmatch.model.LeagueResponse
import com.badikirwan.dicoding.footballmatch.model.Team
import com.badikirwan.dicoding.footballmatch.view.teamdetails.TeamDetailsActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_teams.*

class TeamsFragment : Fragment(), TeamView {

    private val datas: MutableList<Team> = mutableListOf()
    private lateinit var league: League
    private lateinit var presenter: TeamPresenter
    private lateinit var adapter: TeamAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_teams, container, false)

        recyclerView = view.findViewById(R.id.recycle_team)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        presenter = TeamPresenter(this, ApiRepository(), Gson())

        adapter = TeamAdapter(datas) {
            TeamDetailsActivity.start(context, it)
        }

        recyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)

        with(activity as AppCompatActivity) {
            setSupportActionBar(toolbar)
        }

        presenter.getLeague()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.search_menu, menu)

        val searchMenu = menu?.findItem(R.id.search_menu_item)
        val searchView = searchMenu?.actionView as SearchView?

        searchView?.queryHint = "Search by Name"
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter.getSearchTeam(query)
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                if (query.toString().isEmpty()) {
                    spinner_container.visibility = View.VISIBLE
                    presenter.getTeams(spinner.selectedItem.toString())
                } else {
                    spinner_container.visibility = View.GONE
                    presenter.getSearchTeam(query)
                }
                return true
            }

        })
    }

    override fun showLoading() {
        prog_teams.visibility = View.VISIBLE
        recycle_team.visibility = View.INVISIBLE
    }

    override fun hideLoading() {
        prog_teams.visibility = View.INVISIBLE
        recycle_team.visibility = View.VISIBLE
    }

    override fun showListTeam(data: List<Team>) {
        datas.clear()
        datas.addAll(data)
        adapter.notifyDataSetChanged()
    }

    override fun showListLeague(data: LeagueResponse) {
        spinner.adapter = ArrayAdapter(context, R.layout.support_simple_spinner_dropdown_item, data.league)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                league = spinner.selectedItem as League
                presenter.getTeams(league.strLeague.toString())
            }

        }
    }

    override fun showTeamSearch(data: List<Team>) {
        datas.clear()
        datas.addAll(data)
        adapter.notifyDataSetChanged()
    }

}
