package iammert.com.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import iammert.com.data.local.entity.RadioEntity
import iammert.com.data.local.entity.TrendingEntity
import io.reactivex.Flowable

/**
 * Created by mertsimsek on 04/01/2018.
 */
@Dao
abstract class TrendingDao {

    @Insert
    abstract fun insertTrending(trendingEntity: TrendingEntity)

    @Insert
    abstract fun insertTrending(trendEntityList: List<TrendingEntity>)

    @Query("SELECT * FROM radios " +
            "JOIN trending_radios " +
            "ON radios.id = trending_radios.radio_id " +
            "ORDER BY trending_radios.id ASC")
    abstract fun getTrendings() : Flowable<List<RadioEntity>>
}