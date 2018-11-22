package com.badikirwan.dicoding.footballmatch.view.detail

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.R.drawable.ic_add_to_favorites
import com.badikirwan.dicoding.footballmatch.R.drawable.ic_added_to_favorites
import com.badikirwan.dicoding.footballmatch.api.ApiRepository
import com.badikirwan.dicoding.footballmatch.model.EventItem
import com.badikirwan.dicoding.footballmatch.model.Team
import com.badikirwan.dicoding.footballmatch.util.ConvertDateEvent
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailActivityView {

    private lateinit var presenter: DetailActivityPresenter
    private lateinit var event: EventItem
    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false

    companion object {
        private const val INTENT_EVENT = "event"
        fun newIntent(context: Context, eventItem: EventItem) : Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(INTENT_EVENT, eventItem)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.match_detail)

        val intent = intent
        intent?.let {
            event = intent.getParcelableExtra(DetailActivity.INTENT_EVENT)
        }

        presenter = DetailActivityPresenter(this, ApiRepository(), Gson())
        isFavorite = presenter.favoriteState(this, event)

        getDataFromIntent()
        setFavorite()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu
        setFavorite()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.add_to_favorite -> {
                if (isFavorite) {
                    presenter.removeFromFavorite(this, event)
                    Snackbar.make(root_layout, "Remove from favorite", Snackbar.LENGTH_SHORT).show()
                } else {
                    presenter.addToFavorite(this, event)
                    Snackbar.make(root_layout, "Added to favorite", Snackbar.LENGTH_SHORT).show()
                }

                isFavorite = !isFavorite
                setFavorite()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showImageHomeTeam(homeTeam: List<Team>) {
        Glide.with(this)
            .load(homeTeam.get(0).strTeamBadge)
            .into(detail_match_home_badge)
    }

    override fun showImageAwayTeam(awayTeam: List<Team>) {
        Glide.with(this)
            .load(awayTeam.get(0).strTeamBadge)
            .into(detail_match_away_badge)
    }

    private fun getDataFromIntent() {
        detail_match_home.text = event.strHomeTeam
        detail_match_away.text = event.strAwayTeam
        detail_match_date.text = ConvertDateEvent.getFormatDate(event.dateEvent!!)
        detail_match_home_score.text = event.intHomeScore
        detail_match_away_score.text = event.intAwayScore
        detail_match_home_shots.text = event.intHomeShots
        detail_match_away_shots.text = event.intAwayShots
        detail_match_home_goals.text = event.strHomeGoalDetails
        detail_match_away_goals.text = event.strAwayGoalDetails
        detail_match_home_goal_keeper.text = event.strHomeLineupGoalkeeper
        detail_match_away_goal_keeper.text = event.strAwayLineupGoalkeeper
        detail_match_home_defense.text = event.strHomeLineupDefense
        detail_match_away_defense.text = event.strAwayLineupDefense
        detail_match_home_midfield.text = event.strHomeLineupMidfield
        detail_match_away_midfield.text = event.strAwayLineupMidfield
        detail_match_home_forward.text = event.strHomeLineupForward
        detail_match_away_forward.text = event.strAwayLineupForward
        detail_match_home_substitutes.text = event.strHomeLineupSubstitutes
        detail_match_away_substitutes.text = event.strAwayLineupSubstitutes

        presenter.getImageHomeTeam(event.idHomeTeam)
        presenter.getImageAwayeTeam(event.idAwayTeam)
    }

    private fun setFavorite() {
        if (isFavorite) {
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, ic_added_to_favorites)
        } else {
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, ic_add_to_favorites)
        }
    }
}
