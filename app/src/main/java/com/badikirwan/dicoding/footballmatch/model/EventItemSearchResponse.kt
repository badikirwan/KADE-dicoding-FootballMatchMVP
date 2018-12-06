package com.badikirwan.dicoding.footballmatch.model

import com.google.gson.annotations.SerializedName

data class EventItemSearchResponse(
    @SerializedName("event") val event: List<EventItem>
)