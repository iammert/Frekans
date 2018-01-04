package iammert.com.data.local.entity

import android.arch.persistence.room.*
import android.arch.persistence.room.ForeignKey.CASCADE

/**
 * Created by mertsimsek on 04/01/2018.
 */
@Entity(tableName = "trending_radios",
        indices = [(Index(value = "radio_id"))],
        foreignKeys = [ForeignKey(
                entity = RadioEntity::class,
                parentColumns = ["id"],
                childColumns = ["radio_id"],
                onDelete = CASCADE)])
data class TrendingEntity(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
                          @ColumnInfo(name = "radio_id") val radioId: String)