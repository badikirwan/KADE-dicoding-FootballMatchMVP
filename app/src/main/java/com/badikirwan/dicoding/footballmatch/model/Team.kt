package com.badikirwan.dicoding.footballmatch.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
    @SerializedName("idTeam")
    var idTeam: String? = null,

    @SerializedName("strTeamBadge")
    var strTeamBadge: String? = null
) : Parcelable