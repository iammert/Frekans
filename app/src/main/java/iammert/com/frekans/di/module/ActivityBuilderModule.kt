package iammert.com.frekans.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import iammert.com.frekans.di.scope.ActivityScope
import iammert.com.frekans.ui.main.MainActivity

/**
 * Created by mertsimsek on 12/11/2017.
 */
@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(FragmentBuilderModule::class))
    abstract fun mainActivity(): MainActivity
}