package com.badikirwan.dicoding.footballmatch.view.nextmatch


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.adapter.MatchAdapter
import com.badikirwan.dicoding.footballmatch.api.ApiClient
import com.badikirwan.dicoding.footballmatch.model.EventItem
import kotlinx.android.synthetic.main.fragment_last_match.*

class NextMatchFragment : Fragment(), NextMatchView {

    private val data: MutableList<EventItem> = mutableListOf()
    private lateinit var presenter: NextMatchPresenter
    private lateinit var adapter: MatchAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_next_match, container, false)
        recyclerView = view.findViewById(R.id.recycle_last_match)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        presenter = NextMatchPresenter(this, ApiClient)
        adapter = MatchAdapter(data)
        recyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.getNextEventMatch("4328")
    }

    override fun showLoading() {
        prog_last_match.visibility = View.VISIBLE
        recycle_last_match.visibility = View.INVISIBLE
    }

    override fun hideLoading() {
        prog_last_match.visibility = View.GONE
        recycle_last_match.visibility = View.VISIBLE
    }

    override fun showNextEventMatch(eventItem: List<EventItem>) {
        data.clear()
        data.addAll(eventItem)
        adapter.notifyDataSetChanged()
    }
}
