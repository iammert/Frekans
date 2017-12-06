package iammert.com.frekans.player

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import iammert.com.player.PlayerListener

/**
 * Created by mertsimsek on 06/12/2017.
 */
class ExoPlayerService : Service(), PlayerListener{

    private val binder = PlayerServiceBinder()

    inner class PlayerServiceBinder : Binder() {
        fun getService() = this@ExoPlayerService
    }

    override fun onBind(intent: Intent?): IBinder = binder

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_NOT_STICKY
    }

    override fun onLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPlaying() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onIdle() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}