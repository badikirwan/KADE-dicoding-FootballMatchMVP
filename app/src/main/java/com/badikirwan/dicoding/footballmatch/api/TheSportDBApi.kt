package com.badikirwan.dicoding.footballmatch.api

import com.badikirwan.dicoding.footballmatch.BuildConfig

object TheSportDBApi {

    fun getPastMatch(id: String?): String {
        return BuildConfig.BASE_URL+"eventspastleague.php?id="+ id
    }

    fun getNextMatch(id: String?): String {
        return BuildConfig.BASE_URL+"eventsnextleague.php?id="+ id
    }

    fun getImageTeam(id: String?): String {
        return BuildConfig.BASE_URL+"lookupteam.php?id="+ id
    }
}