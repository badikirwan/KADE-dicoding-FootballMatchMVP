package com.badikirwan.dicoding.footballmatch.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Team(
    val id: Long?,
    @SerializedName("idTeam")
    var idTeam: String?,
    @SerializedName("strTeamBadge")
    var strTeamBadge: String?,
    @SerializedName("strTeam")
    val strTeam: String?,
    @SerializedName("intFormedYear")
    val intFormedYear: String?,
    @SerializedName("strStadium")
    val strStadium: String?,
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String?
) : Parcelable {

    companion object {
        const val TABLE_TEAMS = "TABLE_TEAMS"
        const val ID = "ID"
        const val ID_TEAM = "ID_TEAM"
        const val TEAM_BADGE = "TEAM_BADGE"
        const val TEAM = "TEAM"
        const val FORMED_YEAR = "FORMED_YEAR"
        const val STADIUM = "STADIUM"
        const val DESCRIPTION = "DESCRIPTION"
    }
}