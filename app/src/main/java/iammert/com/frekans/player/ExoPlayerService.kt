package iammert.com.frekans.player

import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import dagger.android.DaggerService
import iammert.com.data.remote.model.Stream
import iammert.com.player.PlayerState
import io.reactivex.subjects.Subject
import javax.inject.Inject

/**
 * Created by mertsimsek on 06/12/2017.
 */
class ExoPlayerService : DaggerService() {

    private val binder by lazy { PlayerServiceBinder() }

    @Inject
    lateinit var playerWrapper: PlayerWrapper

    inner class PlayerServiceBinder : Binder() {
        fun getService() = this@ExoPlayerService
    }

    override fun onBind(intent: Intent?): IBinder = binder

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_NOT_STICKY
    }

    fun getPlayerState(): Subject<PlayerState> = playerWrapper.playerStateSubject

    fun start(stream: Stream) = playerWrapper.start(stream)

    fun stop() = playerWrapper.stop()

    companion object {
        fun newIntent(context: Context) = Intent(context, ExoPlayerService::class.java)
        fun getService(binder: IBinder?): ExoPlayerService {
            return (binder as ExoPlayerService.PlayerServiceBinder?)!!.getService()
        }
    }
}