package com.badikirwan.dicoding.footballmatch.view.favoriteevent


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.adapter.MatchAdapter
import com.badikirwan.dicoding.footballmatch.model.EventItem
import com.badikirwan.dicoding.footballmatch.view.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_favorite_event.*

class FavoriteEventFragment : Fragment(), FavoriteEventView {

    private val data: MutableList<EventItem> = mutableListOf()
    private lateinit var presenter: FavoriteEventPresenter
    private lateinit var adapter: MatchAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favorite_event, container, false)
        recyclerView = view.findViewById(R.id.recycle_fav)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        presenter = FavoriteEventPresenter(this)
        adapter = MatchAdapter(data) { eventItem ->
            startActivity(context?.let { DetailActivity.newIntent(it, eventItem) })
        }

        recyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.getFavoriteEvent(this.context!!)
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
        presenter.getFavoriteEvent(this.context!!)
    }

    override fun showFavoriteEvent(eventItem: List<EventItem>) {
        data.clear()
        data.addAll(eventItem)
        adapter.notifyDataSetChanged()
    }


}
