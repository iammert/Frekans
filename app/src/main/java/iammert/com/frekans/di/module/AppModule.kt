package iammert.com.frekans.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import iammert.com.frekans.FrekansApplication
import javax.inject.Singleton

/**
 * Created by mertsimsek on 08/11/2017.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(frekansApplication: FrekansApplication): Context {
        return frekansApplication.applicationContext
    }
}