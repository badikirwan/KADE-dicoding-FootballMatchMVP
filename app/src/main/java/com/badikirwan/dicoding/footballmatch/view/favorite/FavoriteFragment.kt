package com.badikirwan.dicoding.footballmatch.view.favorite


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.adapter.MatchAdapter
import com.badikirwan.dicoding.footballmatch.adapter.PagerAdapter
import com.badikirwan.dicoding.footballmatch.model.EventItem
import com.badikirwan.dicoding.footballmatch.view.favorite.match.FavoriteMatchFragment
import com.badikirwan.dicoding.footballmatch.view.favorite.team.FavoriteTeamFragment
import kotlinx.android.synthetic.main.fragment_favorite_event.*
import kotlinx.android.synthetic.main.fragment_favorite_event.view.*

class FavoriteFragment : Fragment() {

    private val data: MutableList<EventItem> = mutableListOf()
    private lateinit var presenter: FavoritePresenter
    private lateinit var adapter: MatchAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favorite_event, container, false)

        view.view_pager.adapter = PagerAdapter(childFragmentManager, mapOf(
            "Match" to FavoriteMatchFragment(),
            "Team" to FavoriteTeamFragment()
        ))
        view.tab_layout.setupWithViewPager(view.view_pager)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        with(activity as AppCompatActivity) {
            setSupportActionBar(toolbar)
        }
    }
}
