package com.badikirwan.dicoding.footballmatch.model

import com.google.gson.annotations.SerializedName

data class EventItemResponse(
    @SerializedName("events") val events: List<EventItem>
)