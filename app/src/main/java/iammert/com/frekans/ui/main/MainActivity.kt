package iammert.com.frekans.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import iammert.com.frekans.R
import iammert.com.frekans.databinding.ActivityMainBinding
import iammert.com.frekans.ui.BaseActivity
import iammert.com.frekans.ui.home.HomeFragment
import iammert.com.frekans.util.extension.reObserve

/**
 * Created by mertsimsek on 06/11/2017.
 */
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.bottomBar.setOnTabSelectListener(
                { tabId ->
                    when (tabId) {
                        R.id.tab_home -> viewModel.navigate(MainViewModel.NavigationItem.HOME)
                    }

                }, false)

        viewModel.navigation().reObserve(this, Observer { navigate(it) })
    }

    private fun navigate(navigationItem: MainViewModel.NavigationItem?) {
        when (navigationItem) {
            MainViewModel.NavigationItem.HOME -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container, HomeFragment.newInstance())
                    .commit()
            else -> {
            }
        }
    }
}