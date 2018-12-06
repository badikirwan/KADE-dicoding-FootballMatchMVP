package com.badikirwan.dicoding.footballmatch.view.teamdetails.overview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.badikirwan.dicoding.footballmatch.R
import kotlinx.android.synthetic.main.fragment_team_overview.*
import org.jetbrains.anko.bundleOf

class TeamOverviewFragment : Fragment() {

    companion object {
        private const val EXTRA_PARAM = "EXTRA_PARAM"

        fun newInstance(desc: String): TeamOverviewFragment {
            val fragment = TeamOverviewFragment()
            fragment.arguments = bundleOf(EXTRA_PARAM to desc)

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_overview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_overview.text = arguments?.getString(EXTRA_PARAM)
    }
}
