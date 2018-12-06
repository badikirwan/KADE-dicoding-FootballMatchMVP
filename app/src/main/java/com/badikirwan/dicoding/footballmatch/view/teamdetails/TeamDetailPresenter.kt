package com.badikirwan.dicoding.footballmatch.view.teamdetails

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import com.badikirwan.dicoding.footballmatch.db.database
import com.badikirwan.dicoding.footballmatch.model.Team
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.select
import org.jetbrains.anko.toast

class TeamDetailPresenter {

    fun isFavorite(context: Context, data: Team): Boolean {
        var bFavorite = false

        context.database.use {
            val favorites = select(Team.TABLE_TEAMS)
                .whereArgs(Team.ID_TEAM + " = {id}",
                    "id" to data.idTeam.toString())
                .parseList(classParser<Team>())

            bFavorite = !favorites.isEmpty()
        }

        return bFavorite
    }


    fun addFavorites(context: Context, data: Team) {
        try {
            context.database.use {
                insert(Team.TABLE_TEAMS,
                    Team.ID_TEAM to data.idTeam,
                    Team.TEAM_BADGE to data.strTeamBadge,
                    Team.TEAM to data.strTeam,
                    Team.FORMED_YEAR to data.intFormedYear,
                    Team.STADIUM to data.strStadium,
                    Team.DESCRIPTION to data.strDescriptionEN)
            }
        } catch (e: SQLiteConstraintException) {
            context.toast("Error: ${e.message}")
        }
    }

    fun removeFavorites(context: Context, data: Team) {
        try {
            context.database.use {
                delete(Team.TABLE_TEAMS,
                    Team.ID_TEAM + " = {id}", "id" to data.idTeam.toString())
            }
        } catch (e: SQLiteConstraintException) {
            context.toast("Error: ${e.message}")
        }
    }
}