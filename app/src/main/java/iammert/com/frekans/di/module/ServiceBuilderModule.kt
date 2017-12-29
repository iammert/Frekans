package iammert.com.frekans.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import iammert.com.frekans.player.ExoPlayerService

/**
 * Created by mertsimsek on 19/12/2017.
 */
@Module
abstract class ServiceBuilderModule {

    @ContributesAndroidInjector
    abstract fun exoPlayerService(): ExoPlayerService
}