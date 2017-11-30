package iammert.com.data.local.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by mertsimsek on 30/11/2017.
 */
@Entity(tableName = "streams")
data class StreamEntity(
        @PrimaryKey @ColumnInfo(name = "id") val id: String,
        @ColumnInfo(name = "is_external") val isExternal: Boolean,
        @ColumnInfo(name = "url") val url: String,
        @ColumnInfo(name = "format") val format: String,
        @ColumnInfo(name = "rate") val rate: Int,
        @ColumnInfo(name = "codec") val codec: String,
        @ColumnInfo(name = "content_type") val contentType: String,
        @ColumnInfo(name = "media_type") val mediaType: String,
        @ColumnInfo(name = "protocol") val protocol: String
)