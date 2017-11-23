package iammert.com.frekans.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import iammert.com.frekans.util.SingleLiveEvent
import javax.inject.Inject

/**
 * Created by mertsimsek on 12/11/2017.
 */
class MainViewModel @Inject constructor() : ViewModel() {

    enum class NavigationItem {
        HOME, TRENDING, SEARCH, FAVOURITE, SETTINGS
    }

    private val navigationItem = SingleLiveEvent<NavigationItem>()

    init {
        navigationItem.value = NavigationItem.HOME
    }

    fun navigation(): LiveData<NavigationItem> = navigationItem

    fun navigate(item: NavigationItem) {
        navigationItem.value = item
    }

}

