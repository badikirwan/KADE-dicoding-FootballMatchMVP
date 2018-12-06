package com.badikirwan.dicoding.footballmatch.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.badikirwan.dicoding.footballmatch.view.lastmatch.LastMatchFragment
import com.badikirwan.dicoding.footballmatch.view.nextmatch.NextMatchFragment

class MatchEventPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    private val pages = listOf(
        LastMatchFragment(),
        NextMatchFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Last Match"
            1 -> "Next Match"
            else -> {
                "hh"
            }
        }
    }
}