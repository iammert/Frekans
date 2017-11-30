package iammert.com.frekans.data.local.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by mertsimsek on 20/11/2017.
 */
@Entity(tableName = "genres")
data class GenreEntity(
        @PrimaryKey @ColumnInfo(name = "genre_id") val genreId: Long,
        @ColumnInfo(name = "genre_name") val genreName: String,
        @ColumnInfo(name = "genre_image_url") val imageUrl: String
)