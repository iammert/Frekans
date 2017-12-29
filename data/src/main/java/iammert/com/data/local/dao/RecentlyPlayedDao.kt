package iammert.com.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import iammert.com.data.local.entity.RecentlyPlayedEntity
import io.reactivex.Flowable

/**
 * Created by mertsimsek on 29/12/2017.
 */
@Dao
abstract class RecentlyPlayedDao {

    @Insert
    abstract fun insertRecentlyPlayedRadio(recentlyPlayedEntity: RecentlyPlayedEntity)

    @Query("SELECT * FROM recently_played_radio")
    abstract fun getRecentlyPlayedRadios(): Flowable<List<RecentlyPlayedEntity>>
}