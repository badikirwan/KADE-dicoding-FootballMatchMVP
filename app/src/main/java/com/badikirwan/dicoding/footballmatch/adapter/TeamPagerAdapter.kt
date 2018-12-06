package com.badikirwan.dicoding.footballmatch.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.badikirwan.dicoding.footballmatch.model.Team
import com.badikirwan.dicoding.footballmatch.view.teamdetails.players.PlayerTeamFragment
import com.badikirwan.dicoding.footballmatch.view.teamdetails.overview.TeamOverviewFragment

class TeamPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    private lateinit var team: Team

    private val pages = listOf(
        TeamOverviewFragment.newInstance(team.strDescriptionEN.toString()),
        PlayerTeamFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "OVERVIEWS"
            else -> {
                "PLAYERS"
            }
        }
    }
}