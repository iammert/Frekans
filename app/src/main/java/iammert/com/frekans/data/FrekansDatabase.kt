package iammert.com.frekans.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import iammert.com.frekans.data.local.dao.GenreDao
import iammert.com.frekans.data.local.entity.GenreEntity

/**
 * Created by mertsimsek on 20/11/2017.
 */
@Database(
        entities = arrayOf(GenreEntity::class),
        version = 1)
abstract class FrekansDatabase : RoomDatabase() {
    abstract fun getGenreDao(): GenreDao
}