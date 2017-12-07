package iammert.com.frekans.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import iammert.com.frekans.FrekansApplication
import iammert.com.frekans.util.tool.StethoTool
import iammert.com.frekans.util.tool.Tools
import javax.inject.Singleton

/**
 * Created by mertsimsek on 08/11/2017.
 */
@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(frekansApplication: FrekansApplication): Context = frekansApplication.applicationContext

    @Provides
    @Singleton
    fun provideTools(stethoTool: StethoTool): Tools {
        return Tools(listOf(stethoTool))
    }
}