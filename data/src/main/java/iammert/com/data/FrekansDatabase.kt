package iammert.com.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import iammert.com.data.local.dao.RadiosDao
import iammert.com.data.local.dao.RecentlyPlayedDao
import iammert.com.data.local.dao.TrendingDao
import iammert.com.data.local.entity.RadioEntity
import iammert.com.data.local.entity.RecentlyPlayedEntity
import iammert.com.data.local.entity.TrendingEntity
import iammert.com.frekans.data.local.dao.GenreDao
import iammert.com.frekans.data.local.entity.GenreEntity

/**
 * Created by mertsimsek on 20/11/2017.
 */
@Database(
        entities = [GenreEntity::class, RadioEntity::class, RecentlyPlayedEntity::class, TrendingEntity::class],
        version = 1)
abstract class FrekansDatabase : RoomDatabase() {

    abstract fun getGenreDao(): GenreDao

    abstract fun getRadiosDao(): RadiosDao

    abstract fun getRecentlyPlayedDao(): RecentlyPlayedDao

    abstract fun getTrendingDao(): TrendingDao
}