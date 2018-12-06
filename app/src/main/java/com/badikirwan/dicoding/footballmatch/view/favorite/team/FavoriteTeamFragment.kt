package com.badikirwan.dicoding.footballmatch.view.favorite.team


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.adapter.TeamAdapter
import com.badikirwan.dicoding.footballmatch.model.EventItem
import com.badikirwan.dicoding.footballmatch.model.Team
import com.badikirwan.dicoding.footballmatch.view.favorite.FavoritePresenter
import com.badikirwan.dicoding.footballmatch.view.favorite.FavoriteView
import com.badikirwan.dicoding.footballmatch.view.teamdetails.TeamDetailsActivity
import kotlinx.android.synthetic.main.fragment_favorite_team.*

class FavoriteTeamFragment : Fragment(), FavoriteView {

    private val data: MutableList<Team> = mutableListOf()
    private lateinit var presenter: FavoritePresenter
    private lateinit var adapter: TeamAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favorite_team, container, false)

        recyclerView = view.findViewById(R.id.recycle_fav)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        presenter = FavoritePresenter(this)
        adapter = TeamAdapter(data) {
            TeamDetailsActivity.start(context, it)
        }

        recyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.getFavoriteTeam(this.context!!)
    }

    override fun showLoading() {
        prog_fav.visibility = View.VISIBLE
        recycle_fav.visibility = View.INVISIBLE
    }

    override fun hideLoading() {
        prog_fav.visibility = View.GONE
        recycle_fav.visibility = View.VISIBLE
    }

    override fun showEmptyData() {
        prog_fav.visibility = View.GONE
        recycle_fav.visibility = View.INVISIBLE
        empty_data.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        presenter.getFavoriteTeam(this.context!!)
    }

    override fun showFavoriteEvent(eventItem: List<EventItem>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showFavoriteTeam(team: List<Team>) {
        data.clear()
        data.addAll(team)
        adapter.notifyDataSetChanged()
    }

}
