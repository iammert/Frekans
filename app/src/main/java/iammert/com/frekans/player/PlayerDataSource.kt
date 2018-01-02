package iammert.com.frekans.player

import android.app.Service
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import iammert.com.data.local.dao.RecentlyPlayedDao
import iammert.com.data.local.entity.RadioEntity
import iammert.com.data.remote.model.Radio
import iammert.com.data.remote.model.Stream
import iammert.com.frekans.repository.RadioRepository
import iammert.com.frekans.util.extension.connection
import iammert.com.player.PlayerState
import io.reactivex.functions.Consumer
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by mertsimsek on 18/12/2017.
 */
@Singleton
class PlayerDataSource @Inject constructor(context: Context,
                                           private val radioRepository: RadioRepository) {

    private val playerStateLiveData = MutableLiveData<PlayerState>()

    val playerState: LiveData<PlayerState>
        get() = playerStateLiveData

    private lateinit var service: ExoPlayerService

    private lateinit var currentRadio: RadioEntity
    private var currentStreamIndex = 0

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
        service.getPlayerState().subscribe { state ->
            playerStateLiveData.value = state
            playNextOnStreamError(state)
        }

        radioRepository.getRecentlyPlayedRadio()
                .distinct()
                .skip(1)
                .subscribe({
                    currentRadio = it
                    currentStreamIndex = 0
                    service.start(it.streams!![currentStreamIndex])
                })
    }

    private fun playNextOnStreamError(state: PlayerState) {
        if (currentRadio.streams?.size?.minus( 1) == currentStreamIndex) {
            return
        }

        if (state == PlayerState.ERROR) {
            currentStreamIndex++
            service.start(currentRadio.streams!![currentStreamIndex])
        }
    }
}