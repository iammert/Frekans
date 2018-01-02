package iammert.com.data.local.entity

import android.arch.persistence.room.*
import android.arch.persistence.room.ForeignKey.CASCADE

/**
 * Created by mertsimsek on 29/12/2017.
 */
@Entity(tableName = "recently_played_radio",
        indices = [(Index(value = "radio_id", unique = true))],
        foreignKeys = [ForeignKey(
                entity = RadioEntity::class,
                parentColumns = ["id"],
                childColumns = ["radio_id"],
                onDelete = CASCADE)])
data class RecentlyPlayedEntity(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
                                @ColumnInfo(name = "radio_id") val radioId: String)