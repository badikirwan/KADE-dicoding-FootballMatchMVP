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
): Parcelable