package iammert.com.frekans.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import iammert.com.base.extensions.plusAssign
import iammert.com.frekans.player.PlayerDataSource
import iammert.com.frekans.player.PlayerDataState
import iammert.com.frekans.util.RxAwareViewModel
import iammert.com.frekans.util.SingleLiveEvent
import iammert.com.player.PlayerState
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by mertsimsek on 12/11/2017.
 */
class MainViewModel @Inject constructor(private val playerDataSource: PlayerDataSource) : RxAwareViewModel() {

    enum class NavigationItem {
        HOME, TRENDING, SEARCH, FAVOURITE, SETTINGS
    }

    private val navigationItem = SingleLiveEvent<NavigationItem>()

    val navigationLiveData: LiveData<NavigationItem>
        get() = navigationItem

    private val playerDataStateLiveData = MutableLiveData<PlayerDataState>()

    val playerState: LiveData<PlayerDataState>
        get() = playerDataStateLiveData

    init {
        navigationItem.value = NavigationItem.HOME
        disposables += playerDataSource.getPlayerDataState()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ playerDataStateLiveData.value = it })
    }

    fun navigate(item: NavigationItem) {
        navigationItem.value = item
    }

    fun controlPlayPause() {
        playerDataStateLiveData.value?.radio ?: return
        playerDataStateLiveData.value?.playerState.let {
            when (it) {
                PlayerState.LOADING -> return
                PlayerState.PLAYING -> playerDataSource.stop()
                else -> {
                    playerDataSource.start()
                }
            }
        }
    }
}

