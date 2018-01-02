package iammert.com.frekans.player

import android.app.Service
import android.content.Context
import iammert.com.data.local.entity.RadioEntity
import iammert.com.frekans.repository.RadioRepository
import iammert.com.frekans.util.extension.connection
import iammert.com.player.PlayerState
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by mertsimsek on 18/12/2017.
 */
@Singleton
class PlayerDataSource @Inject constructor(context: Context,
                                           private val radioRepository: RadioRepository) {

    private val playerDataState = PublishSubject.create<PlayerDataState>()

    private var currentStreamIndex: Int = 0

    private var playerState: PlayerState = PlayerState.IDLE

    private lateinit var currentRadio: RadioEntity

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

    fun getPlayerDataState() = playerDataState

    private fun observe() {
        service.getPlayerState().subscribe { state ->
            playerState = state
            playNextOnStreamError(state)
            emitPlayerDataState()
        }

        radioRepository.getRecentlyPlayedRadio()
                .skip(1)
                .subscribe({
                    currentRadio = it
                    currentStreamIndex = 0
                    start()
                    emitPlayerDataState()
                })
    }

    private fun playNextOnStreamError(state: PlayerState) {
        if (currentRadio.streams?.size?.minus(1) == currentStreamIndex) return

        if (state == PlayerState.ERROR) {
            currentStreamIndex++
            start()
        }
    }

    private fun start() {
        service.start(currentRadio.streams!![currentStreamIndex])
    }

    private fun emitPlayerDataState() {
        playerDataState.onNext(PlayerDataState(currentRadio, playerState, currentStreamIndex))
    }
}