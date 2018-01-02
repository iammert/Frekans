package iammert.com.data.util

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import iammert.com.data.remote.model.Stream
import java.util.*

/**
 * Created by mertsimsek on 02/01/2018.
 */
class RoomConverters {

    @TypeConverter
    fun streamsToJson(stremList: List<Stream>): String {
        return Gson().toJson(stremList)
    }

    @TypeConverter
    fun jsonToStreams(streamJson: String): List<Stream> {
        return Gson().fromJson<List<Stream>>(
                streamJson,
                object : TypeToken<ArrayList<Stream>>() {}.type)
    }

    @TypeConverter
    fun dateToLong(date: Date) = date.time

    @TypeConverter
    fun longToDate(time: Long) = Date(time)
}