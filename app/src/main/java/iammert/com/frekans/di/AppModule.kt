package iammert.com.frekans.di

import android.content.Context
import dagger.Module
import dagger.Provides
import iammert.com.frekans.FrekansApplication

/**
 * Created by mertsimsek on 08/11/2017.
 */
@Module
class AppModule {

    @Provides
    fun provideContext(frekansApplication: FrekansApplication): Context {
        return frekansApplication.applicationContext
    }
}