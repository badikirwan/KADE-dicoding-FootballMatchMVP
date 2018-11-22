package com.badikirwan.dicoding.footballmatch.view.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.R.id.*
import com.badikirwan.dicoding.footballmatch.view.favoriteevent.FavoriteEventFragment
import com.badikirwan.dicoding.footballmatch.view.lastmatch.LastLastMatchFragment
import com.badikirwan.dicoding.footballmatch.view.nextmatch.NextMatchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                menu_last_match -> {
                    loadLastMatchFragment(savedInstanceState)
                }

                menu_next_match -> {
                    loadNextMatchFragment(savedInstanceState)
                }

                menu_favorite -> {
                    loadFavoriteFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = menu_last_match
    }

    private fun loadLastMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, LastLastMatchFragment(), LastLastMatchFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadNextMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, NextMatchFragment(), NextMatchFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadFavoriteFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, FavoriteEventFragment(), FavoriteEventFragment::class.java.simpleName)
                .commit()
        }
    }
}
