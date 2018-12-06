package com.badikirwan.dicoding.footballmatch.model

import com.google.gson.annotations.SerializedName

data class LeagueResponse(
    @SerializedName("leagues") val league: List<League>
)