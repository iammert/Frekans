package iammert.com.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by mertsimsek on 30/11/2017.
 */
data class Stream(
        @SerializedName("is_external") val isExternal: Boolean,
        @SerializedName("id") val id: String,
        @SerializedName("url") val url: String,
        @SerializedName("format") val format: String,
        @SerializedName("rate") val rate: Int,
        @SerializedName("codec") val codec: String,
        @SerializedName("content_type") val contentType: String,
        @SerializedName("media_type") val mediaType: String,
        @SerializedName("protocol") val protocol: String)