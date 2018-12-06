package com.badikirwan.dicoding.footballmatch.view.match


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.*

import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.adapter.PagerAdapter
import com.badikirwan.dicoding.footballmatch.view.match.lastmatch.LastMatchFragment
import com.badikirwan.dicoding.footballmatch.view.match.nextmatch.NextMatchFragment
import com.badikirwan.dicoding.footballmatch.view.searchmatch.SearchMatchActivity
import kotlinx.android.synthetic.main.fragment_home_match.*
import kotlinx.android.synthetic.main.fragment_home_match.view.*
import org.jetbrains.anko.startActivity

class HomeMatchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home_match, container, false)
        setHasOptionsMenu(true)
        view.view_pager.adapter = PagerAdapter(childFragmentManager, mapOf(
            getString(R.string.last_match) to LastMatchFragment(),
            getString(R.string.next_match) to NextMatchFragment()
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

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.search_menu_match, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.mn_search -> {
                context?.startActivity<SearchMatchActivity>()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
