package com.badikirwan.dicoding.footballmatch.view.teamdetails.players


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.adapter.PlayerAdapter
import com.badikirwan.dicoding.footballmatch.api.ApiRepository
import com.badikirwan.dicoding.footballmatch.model.Player
import com.badikirwan.dicoding.footballmatch.view.playerdetails.PlayerDetailActivity
import com.google.gson.Gson
import org.jetbrains.anko.bundleOf


class PlayerTeamFragment : Fragment(), PlayerView {

    companion object {
        private const val EXTRA_PARAM = "EXTRA_PARAM"

        fun newInstance(desc: String): PlayerTeamFragment {
            val fragment = PlayerTeamFragment()
            fragment.arguments = bundleOf(EXTRA_PARAM to desc)

            return fragment
        }
    }

    private var player: MutableList<Player> = mutableListOf()
    private lateinit var adapter: PlayerAdapter
    private lateinit var presenter: PlayerPresenter
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_player_team, container, false)

        recyclerView = view.findViewById(R.id.rv_player)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        presenter = PlayerPresenter(this, ApiRepository(), Gson())

        adapter = PlayerAdapter(player) {
            PlayerDetailActivity.start(context, it)
        }

        recyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getPlayerTeam(arguments?.getString(EXTRA_PARAM).toString())
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showPlayerTeam(data: List<Player>) {
        player.clear()
        player.addAll(data)
        adapter.notifyDataSetChanged()
    }


}
