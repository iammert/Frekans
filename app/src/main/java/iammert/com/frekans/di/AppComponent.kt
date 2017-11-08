package iammert.com.frekans.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import iammert.com.frekans.FrekansApplication
import javax.inject.Singleton

/**
 * Created by mertsimsek on 08/11/2017.
 */
@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class))
interface AppComponent : AndroidInjector<FrekansApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<FrekansApplication>()
}