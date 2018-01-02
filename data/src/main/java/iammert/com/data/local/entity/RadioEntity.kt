package iammert.com.data.local.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import iammert.com.data.remote.model.Stream
import iammert.com.data.util.RoomConverters

/**
 * Created by mertsimsek on 30/11/2017.
 */
@Entity(tableName = "radios")
@TypeConverters(RoomConverters::class)
data class RadioEntity(
        @PrimaryKey @ColumnInfo(name = "id") val id: String,
        @ColumnInfo(name = "radio_name") val radioName: String,
        @ColumnInfo(name = "website") val website: String,
        @ColumnInfo(name = "band") val band: String,
        @ColumnInfo(name = "city") val city: String,
        @ColumnInfo(name = "dial") val dial: String,
        @ColumnInfo(name = "language") val language: String,
        @ColumnInfo(name = "country") val country: String,
        @ColumnInfo(name = "streams") val streams: List<Stream>,
        @ColumnInfo(name = "logo_small") val logoSmall: String,
        @ColumnInfo(name = "logo_big") val logoBig: String,
        @ColumnInfo(name = "listener_count") val listenerCount: String)