package com.badikirwan.dicoding.footballmatch.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class PagerAdapter(fm: FragmentManager, private val map: Map<String, Fragment>)
    : FragmentStatePagerAdapter(fm) {

    private val title = map.keys.toList()
    private val fragment = map.values.toList()

    override fun getItem(p0: Int): Fragment {
        return fragment[p0]
    }

    override fun getCount(): Int = map.size

    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }
}