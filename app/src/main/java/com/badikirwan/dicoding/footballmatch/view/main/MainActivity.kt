package com.badikirwan.dicoding.footballmatch.view.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.R.id.*
import com.badikirwan.dicoding.footballmatch.view.favorite.FavoriteFragment
import com.badikirwan.dicoding.footballmatch.view.match.HomeMatchFragment
import com.badikirwan.dicoding.footballmatch.view.team.TeamsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                menu_last_match -> {
                    loadHomeMatchFragment(savedInstanceState)
                }

                menu_next_match -> {
                    loadTeamFragment(savedInstanceState)
                }

                menu_favorite -> {
                    loadFavoriteFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = menu_last_match
    }

    private fun loadHomeMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container,
                    HomeMatchFragment(), HomeMatchFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadTeamFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, TeamsFragment(), TeamsFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadFavoriteFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container,
                    FavoriteFragment(), FavoriteFragment::class.java.simpleName)
                .commit()
        }
    }
}
