package com.badikirwan.dicoding.footballmatch.view.teamdetails

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.adapter.PagerAdapter
import com.badikirwan.dicoding.footballmatch.model.Team
import com.badikirwan.dicoding.footballmatch.view.teamdetails.overview.TeamOverviewFragment
import com.badikirwan.dicoding.footballmatch.view.teamdetails.players.PlayerTeamFragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_team_details.*
import org.jetbrains.anko.startActivity

class TeamDetailsActivity : AppCompatActivity() {

    private lateinit var team: Team
    private lateinit var presenter: TeamDetailPresenter
    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false

    companion object {
        private const val EXTRA_PARAM = "EXTRA_PARAM"

        fun start(context: Context?, team: Team) {
            context?.startActivity<TeamDetailsActivity>(EXTRA_PARAM to team)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_details)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        team = intent.getParcelableExtra(EXTRA_PARAM)

        presenter = TeamDetailPresenter()
        isFavorite = presenter.isFavorite(this, team)

        getDataFromItent()
        setFavorite()

        view_pager.adapter = PagerAdapter(supportFragmentManager, mapOf(
            getString(R.string.overview_team) to TeamOverviewFragment.newInstance(team.strDescriptionEN.toString()),
            getString(R.string.players_team) to PlayerTeamFragment.newInstance(team.idTeam.toString())
        ))

        tab_layout.setupWithViewPager(view_pager)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu
        setFavorite()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            R.id.add_to_favorite -> {
                if (isFavorite) {
                    presenter.removeFavorites(this, team)
                    Snackbar.make(root_layout, "Remove from favorite", Snackbar.LENGTH_SHORT).show()
                } else {
                    presenter.addFavorites(this, team)
                    Snackbar.make(root_layout, "Added to favorite", Snackbar.LENGTH_SHORT).show()
                }

                isFavorite = !isFavorite
                setFavorite()

                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getDataFromItent() {
        tv_name.text = team.strTeam
        tv_year.text = team.intFormedYear
        tv_stadium.text = team.strStadium

        Glide.with(this).load(team.strTeamBadge).into(iv_team)
    }

    private fun setFavorite() {
        if (isFavorite) {
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_added_to_favorites)
        } else {
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_add_to_favorites)
        }
    }

}
