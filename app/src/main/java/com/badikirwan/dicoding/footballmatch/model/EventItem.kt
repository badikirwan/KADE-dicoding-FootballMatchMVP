package com.badikirwan.dicoding.footballmatch.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EventItem(
    val id: Long?,
    @SerializedName("idEvent")
    val idEvent: String?,
    @SerializedName("dateEvent")
    val dateEvent: String?,
    @SerializedName("idHomeTeam")
    val idHomeTeam: String?,
    @SerializedName("strHomeTeam")
    val strHomeTeam: String?,
    @SerializedName("intHomeScore")
    val intHomeScore: String?,
    @SerializedName("strHomeFormation")
    val strHomeFormation: String?,
    @SerializedName("strHomeGoalDetails")
    val strHomeGoalDetails: String?,
    @SerializedName("intHomeShots")
    val intHomeShots: String?,
    @SerializedName("strHomeLineupGoalkeeper")
    val strHomeLineupGoalkeeper: String?,
    @SerializedName("strHomeLineupDefense")
    val strHomeLineupDefense: String?,
    @SerializedName("strHomeLineupMidfield")
    val strHomeLineupMidfield: String?,
    @SerializedName("strHomeLineupForward")
    val strHomeLineupForward: String?,
    @SerializedName("strHomeLineupSubstitutes")
    val strHomeLineupSubstitutes: String?,
    @SerializedName("idAwayTeam")
    val idAwayTeam: String?,
    @SerializedName("strAwayTeam")
    val strAwayTeam: String?,
    @SerializedName("intAwayScore")
    val intAwayScore: String?,
    @SerializedName("strAwayFormation")
    val strAwayFormation: String?,
    @SerializedName("strAwayGoalDetails")
    val strAwayGoalDetails: String?,
    @SerializedName("intAwayShots")
    val intAwayShots: String?,
    @SerializedName("strAwayLineupGoalkeeper")
    val strAwayLineupGoalkeeper: String?,
    @SerializedName("strAwayLineupDefense")
    val strAwayLineupDefense: String?,
    @SerializedName("strAwayLineupMidfield")
    val strAwayLineupMidfield: String?,
    @SerializedName("strAwayLineupForward")
    val strAwayLineupForward: String?,
    @SerializedName("strAwayLineupSubstitutes")
    val strAwayLineupSubstitutes: String?
): Parcelable {

    companion object {
        const val TABLE_FAVORITES = "TABLE_FAVORITES"
        const val ID = "ID"
        const val ID_EVENT = "ID_EVENT"
        const val DATE = "DATE"
        const val HOME_ID = "HOME_ID"
        const val HOME_TEAM = "HOME_TEAM"
        const val HOME_SCORE = "HOME_SCORE"
        const val HOME_FORMATION = "HOME_FORMATION"
        const val HOME_GOAL_DETAILS = "HOME_GOAL_DETAILS"
        const val HOME_SHOTS = "HOME_SHOTS"
        const val HOME_LINEUP_GOALKEEPER = "HOME_LINEUP_GOALKEEPER"
        const val HOME_LINEUP_DEFENSE = "HOME_LINEUP_DEFENSE"
        const val HOME_LINEUP_MIDFIELD = "HOME_LINEUP_MIDFIELD"
        const val HOME_LINEUP_FORWARD = "HOME_LINEUP_FORWARD"
        const val HOME_LINEUP_SUBSTITUTES = "HOME_LINEUP_SUBSTITUTES"
        const val AWAY_ID = "AWAY_ID"
        const val AWAY_TEAM = "AWAY_TEAM"
        const val AWAY_SCORE = "AWAY_SCORE"
        const val AWAY_FORMATION = "AWAY_FORMATION"
        const val AWAY_GOAL_DETAILS = "AWAY_GOAL_DETAILS"
        const val AWAY_SHOTS = "AWAY_SHOTS"
        const val AWAY_LINEUP_GOALKEEPER = "AWAY_LINEUP_GOALKEEPER"
        const val AWAY_LINEUP_DEFENSE = "AWAY_LINEUP_DEFENSE"
        const val AWAY_LINEUP_MIDFIELD = "AWAY_LINEUP_MIDFIELD"
        const val AWAY_LINEUP_FORWARD = "AWAY_LINEUP_FORWARD"
        const val AWAY_LINEUP_SUBSTITUTES = "AWAY_LINEUP_SUBSTITUTES"
    }
}