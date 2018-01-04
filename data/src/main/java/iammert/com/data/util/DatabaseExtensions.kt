package iammert.com.data.util

import android.arch.persistence.room.RoomDatabase

/**
 * Created by mertsimsek on 04/01/2018.
 */
fun RoomDatabase.transaction(func: RoomDatabase.() -> Unit){
    beginTransaction()
    func()
    endTransaction()
}