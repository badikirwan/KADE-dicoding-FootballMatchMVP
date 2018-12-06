package com.badikirwan.dicoding.footballmatch.model

import com.google.gson.annotations.SerializedName

class PlayerResponse (
    @SerializedName("player") val player: List<Player>
)