package com.badikirwan.dicoding.footballmatch.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player(
    @SerializedName("strCutout")
    val strCutout: String?,
    @SerializedName("strPlayer")
    val strPlayer: String?,
    @SerializedName("strPosition")
    val strPosition: String?,
    @SerializedName("strWeight")
    val strWeight: String?,
    @SerializedName("strHeight")
    val strHeight: String?,
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String?,
    @SerializedName("strFanart1")
    val strFanart1: String?
) : Parcelable
