package iammert.com.frekans.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import iammert.com.frekans.data.local.entity.GenreEntity
import io.reactivex.Flowable

/**
 * Created by mertsimsek on 20/11/2017.
 */
@Dao
abstract class GenreDao {

    @Insert
    abstract fun insertGenre(list: List<GenreEntity>)

    @Query("SELECT * FROM genres")
    abstract fun getGenres(): Flowable<List<GenreEntity>>

}