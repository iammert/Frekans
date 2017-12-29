package iammert.com.frekans.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import iammert.com.frekans.player.PlayerDataSource
import iammert.com.frekans.util.SingleLiveEvent
import iammert.com.player.PlayerState
import javax.inject.Inject

/**
 * Created by mertsimsek on 12/11/2017.
 */
class MainViewModel @Inject constructor(private val playerDataSource: PlayerDataSource) : ViewModel() {

    enum class NavigationItem {
        HOME, TRENDING, SEARCH, FAVOURITE, SETTINGS
    }

    private val navigationItem = SingleLiveEvent<NavigationItem>()

    val navigationLiveData: LiveData<NavigationItem>
        get() = navigationItem

    val playerState: LiveData<PlayerState>
        get() = playerDataSource.playerState

    init {
        navigationItem.value = NavigationItem.HOME
    }

    fun navigate(item: NavigationItem) {
        navigationItem.value = item
    }

}

