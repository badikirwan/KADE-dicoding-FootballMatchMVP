package com.badikirwan.dicoding.footballmatch.view.searchmatch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.View
import android.widget.SearchView
import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.adapter.MatchAdapter
import com.badikirwan.dicoding.footballmatch.api.ApiRepository
import com.badikirwan.dicoding.footballmatch.model.EventItem
import com.badikirwan.dicoding.footballmatch.view.detail.DetailActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_search_match.*

class SearchMatchActivity : AppCompatActivity(), SearchMatchView {

    private val datas: MutableList<EventItem> = mutableListOf()
    private lateinit var presenter: SearchMatchPresenter
    private lateinit var adapter: MatchAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_match)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.rv_match_search)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        presenter = SearchMatchPresenter(this, ApiRepository(), Gson())

        adapter = MatchAdapter(datas) { eventItem ->
            startActivity(this.let { DetailActivity.newIntent(it, eventItem) })
        }

        recyclerView.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        val searchMenu = menu?.findItem(R.id.search_menu_item)
        val searchView = searchMenu?.actionView as SearchView?

        searchView?.queryHint = "Search by Teams"
        searchView?.isIconified = false
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter.getSearchMatch(query.toString())
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                if (query.toString().isEmpty()) {
                    rv_match_search.visibility = View.INVISIBLE
                } else {
                    presenter.getSearchMatch(query.toString())
                }
                return true
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun showLoading() {
        prog_search_match.visibility = View.VISIBLE
        rv_match_search.visibility = View.INVISIBLE
    }

    override fun hideLoading() {
        prog_search_match.visibility = View.INVISIBLE
        rv_match_search.visibility = View.VISIBLE
    }

    override fun showSearchMatch(data: List<EventItem>) {
        datas.clear()
        datas.addAll(data)
        adapter.notifyDataSetChanged()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
