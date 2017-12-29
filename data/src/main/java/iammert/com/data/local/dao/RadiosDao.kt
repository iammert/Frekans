package iammert.com.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import iammert.com.data.local.entity.RadioEntity

/**
 * Created by mertsimsek on 29/12/2017.
 */
@Dao
abstract class RadiosDao {

    @Insert
    abstract fun insertRadio(radioEntity: RadioEntity)
}