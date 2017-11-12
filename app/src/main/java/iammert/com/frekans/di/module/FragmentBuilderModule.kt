package iammert.com.frekans.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import iammert.com.frekans.di.scope.FragmentScope
import iammert.com.frekans.ui.favourite.FavouriteFragment
import iammert.com.frekans.ui.home.HomeFragment
import iammert.com.frekans.ui.search.SearchFragment
import iammert.com.frekans.ui.settings.SettingsFragment
import iammert.com.frekans.ui.trending.TrendingFragment

/**
 * Created by mertsimsek on 12/11/2017.
 */
@Module
abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun trendingFragment(): TrendingFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun searchFragment(): SearchFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun favouriteFragment(): FavouriteFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun settingsFragment(): SettingsFragment

}