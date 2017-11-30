package iammert.com.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by mertsimsek on 30/11/2017.
 */
data class Radio(
        @SerializedName("id") val id: String,
        @SerializedName("radio_name") val radioName: String,
        @SerializedName("website") val website: String,
        @SerializedName("band") val band: String,
        @SerializedName("city") val city: String,
        @SerializedName("dial") val dial: String,
        @SerializedName("language") val language: String,
        @SerializedName("country") val country: String,
        @SerializedName("streams") val streams: List<Stream>,
        @SerializedName("logo_small") val logoSmall: String,
        @SerializedName("logo_big") val logoBig: String,
        @SerializedName("listener_count") val listenerCount: String)