package iammert.com.frekans.di.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import iammert.com.frekans.FrekansApplication
import iammert.com.frekans.di.module.ActivityBuilderModule
import iammert.com.frekans.di.module.AppModule
import iammert.com.data.DatabaseModule
import iammert.com.data.NetworkModule
import iammert.com.frekans.di.module.ServiceBuilderModule
import iammert.com.player.PlayerModule
import javax.inject.Singleton

/**
 * Created by mertsimsek on 08/11/2017.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    DatabaseModule::class,
    PlayerModule::class,
    ServiceBuilderModule::class,
    ActivityBuilderModule::class])
interface AppComponent : AndroidInjector<FrekansApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<FrekansApplication>()
}