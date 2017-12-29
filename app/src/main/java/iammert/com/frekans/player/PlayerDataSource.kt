package iammert.com.frekans.player

import android.app.Service
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import iammert.com.frekans.util.extension.connection
import iammert.com.player.PlayerState
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by mertsimsek on 18/12/2017.
 */
@Singleton
class PlayerDataSource @Inject constructor(context: Context) {

    private val playerStateLiveData = MutableLiveData<PlayerState>()

    val playerState: LiveData<PlayerState>
        get() = playerStateLiveData

    private lateinit var service: ExoPlayerService

    private val serviceConnection = connection {
        serviceConnected { _, binder ->
            service = ExoPlayerService.getService(binder)
            observe()
        }
    }

    init {
        val intent = ExoPlayerService.newIntent(context.applicationContext)
        context.applicationContext.bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE)
    }

    private fun observe() {
        service.getPlayerState().subscribe { state -> playerStateLiveData.value = state }
    }
}