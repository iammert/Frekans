package iammert.com.frekans.player

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import iammert.com.frekans.util.extension.addIfAbsent
import iammert.com.frekans.util.extension.removeIfExist
import iammert.com.player.PlayerListener
import iammert.com.player.PlayerState

/**
 * Created by mertsimsek on 06/12/2017.
 */
class ExoPlayerService : Service(), PlayerListener {

    private val binder by lazy { PlayerServiceBinder() }
    private val playerWrapper by lazy { PlayerWrapper.getInstance(applicationContext) }
    private val listeners by lazy { ArrayList<PlayerListener>() }

    inner class PlayerServiceBinder : Binder() {
        fun getService() = this@ExoPlayerService
    }

    override fun onBind(intent: Intent?): IBinder = binder

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_NOT_STICKY
    }

    fun addPlayerListener(playerListener: PlayerListener) = listeners.addIfAbsent(playerListener)

    fun removePlayerListener(playerListener: PlayerListener) = listeners.removeIfExist(playerListener)

    override fun onStateChanged(state: PlayerState) {
        TODO()
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, ExoPlayerService::class.java)
    }
}