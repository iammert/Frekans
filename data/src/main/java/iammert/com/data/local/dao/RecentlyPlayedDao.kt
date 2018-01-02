package iammert.com.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import iammert.com.data.local.entity.RadioEntity
import iammert.com.data.local.entity.RecentlyPlayedEntity
import iammert.com.data.remote.model.Radio
import io.reactivex.Flowable

/**
 * Created by mertsimsek on 29/12/2017.
 */
@Dao
abstract class RecentlyPlayedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertRecentlyPlayedRadio(recentlyPlayedEntity: RecentlyPlayedEntity)

    @Query("SELECT * FROM radios " +
            "INNER JOIN recently_played_radio " +
            "ON radios.id = recently_played_radio.radio_id " +
            "ORDER BY datetime(date_updated) " +
            "DESC LIMIT 1")
    abstract fun getLastRecentlyPlayedRadio(): Flowable<RadioEntity>
}