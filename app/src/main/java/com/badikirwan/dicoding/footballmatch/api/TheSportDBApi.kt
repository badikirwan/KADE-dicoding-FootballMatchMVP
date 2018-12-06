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

    fun getAllTeam(league: String?): String {
        return BuildConfig.BASE_URL+"search_all_teams.php?l="+ league
    }

    fun getSearchTeam(query: String?): String {
        return BuildConfig.BASE_URL+"searchteams.php?t="+ query
    }

    fun getSearchMatch(query: String?): String {
        return BuildConfig.BASE_URL+"searchevents.php?e="+ query
    }

    fun getLeague(): String {
        return BuildConfig.BASE_URL+"all_leagues.php"
    }

    fun getPlayerTeam(id: String?): String {
        return BuildConfig.BASE_URL+"lookup_all_players.php?id="+ id
    }

}