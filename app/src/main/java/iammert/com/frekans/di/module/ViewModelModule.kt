package iammert.com.frekans.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import iammert.com.frekans.di.key.ViewModelKey
import iammert.com.frekans.di.ViewModelFactory
import iammert.com.frekans.ui.favourite.FavouriteViewModel
import iammert.com.frekans.ui.home.HomeViewModel
import iammert.com.frekans.ui.main.MainViewModel
import iammert.com.frekans.ui.search.SearchViewModel
import iammert.com.frekans.ui.settings.SettingsViewModel
import iammert.com.frekans.ui.trending.TrendingViewModel

/**
 * Created by mertsimsek on 12/11/2017.
 */
@Module
internal abstract class ViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(HomeViewModel::class)
    abstract fun provideHomeVieWModel(homeViewModel: HomeViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(TrendingViewModel::class)
    abstract fun provideTrendingViewModel(trendingViewModel: TrendingViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(SearchViewModel::class)
    abstract fun provideSearchViewModel(searchViewModel: SearchViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(FavouriteViewModel::class)
    abstract fun provideFavouriteViewModel(favouriteViewModel: FavouriteViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(SettingsViewModel::class)
    abstract fun provideSettingsViewModel(settingsViewModel: SettingsViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(MainViewModel::class)
    abstract fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}

