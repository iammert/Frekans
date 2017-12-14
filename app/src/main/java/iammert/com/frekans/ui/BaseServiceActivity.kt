package iammert.com.frekans.ui

import android.arch.lifecycle.ViewModel
import android.content.ComponentName
import android.content.Context
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import iammert.com.frekans.player.ExoPlayerService
import iammert.com.player.PlayerListener
import iammert.com.player.PlayerState

/**
 * Created by mertsimsek on 14/12/2017.
 */
abstract class BaseServiceActivity<T : ViewModel> : BaseActivity<T>(), ServiceConnection, PlayerListener {

    private lateinit var exoPlayerService: ExoPlayerService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindService(ExoPlayerService.newIntent(this), this, Context.BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        exoPlayerService.removePlayerListener(this)
        unbindService(this)
    }

    override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
        val binder = (p1 as ExoPlayerService.PlayerServiceBinder?)!!
        exoPlayerService = binder.getService()
        exoPlayerService.addPlayerListener(this)
    }

    override fun onServiceDisconnected(p0: ComponentName?) {
        exoPlayerService.removePlayerListener(this)
    }

    override fun onStateChanged(state: PlayerState) {
        TODO()
    }
}