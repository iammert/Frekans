package iammert.com.data

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mertsimsek on 20/11/2017.
 */
@Module
class DatabaseModule {

    companion object {
        val DB_NAME = "frekans.db"
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context) = Room.databaseBuilder(context, FrekansDatabase::class.java, DB_NAME).build()

    @Provides
    @Singleton
    fun provideGenreDao(db: FrekansDatabase) = db.getGenreDao()

}