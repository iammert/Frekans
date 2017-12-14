package iammert.com.frekans.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import iammert.com.frekans.R
import iammert.com.frekans.databinding.ActivityMainBinding
import iammert.com.frekans.ui.BaseActivity
import iammert.com.frekans.ui.BaseServiceActivity
import iammert.com.frekans.ui.favourite.FavouriteFragment
import iammert.com.frekans.ui.home.HomeFragment
import iammert.com.frekans.util.extension.reObserve
import iammert.com.frekans.ui.search.SearchFragment
import iammert.com.frekans.ui.settings.SettingsFragment
import iammert.com.frekans.ui.trending.TrendingFragment
import iammert.com.frekans.util.extension.replaceFragment
import iammert.com.frekans.ui.main.MainViewModel.NavigationItem.HOME
import iammert.com.frekans.ui.main.MainViewModel.NavigationItem.TRENDING
import iammert.com.frekans.ui.main.MainViewModel.NavigationItem.SEARCH
import iammert.com.frekans.ui.main.MainViewModel.NavigationItem.FAVOURITE
import iammert.com.frekans.ui.main.MainViewModel.NavigationItem.SETTINGS
import iammert.com.frekans.util.delegates.contentView

/**
 * Created by mertsimsek on 06/11/2017.
 */
class MainActivity : BaseServiceActivity<MainViewModel>() {

    private val binding: ActivityMainBinding by contentView(R.layout.activity_main)

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.bottomBar.setOnTabSelectListener(
                { tabId ->
                    when (tabId) {
                        R.id.tab_home -> viewModel.navigate(HOME)
                        R.id.tab_trending -> viewModel.navigate(TRENDING)
                    }
                })

        viewModel.navigationLiveData.reObserve(this, Observer { navigate(it) })
    }

    private fun navigate(navigationItem: MainViewModel.NavigationItem?) {
        when (navigationItem) {
            HOME -> replaceFragment(R.id.container, HomeFragment.newInstance())
            TRENDING -> replaceFragment(R.id.container, TrendingFragment.newInstance())
            SEARCH -> replaceFragment(R.id.container, SearchFragment.newInstance())
            FAVOURITE -> replaceFragment(R.id.container, FavouriteFragment.newInstance())
            SETTINGS -> replaceFragment(R.id.container, SettingsFragment.newInstance())
        }
    }

}