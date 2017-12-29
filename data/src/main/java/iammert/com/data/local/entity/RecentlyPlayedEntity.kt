package iammert.com.data.local.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by mertsimsek on 29/12/2017.
 */
@Entity(tableName = "recently_played_radio")
data class RecentlyPlayedEntity(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
                                @ColumnInfo(name = "radioId") val radioId: Int)