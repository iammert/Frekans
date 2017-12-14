package iammert.com.frekans.player

import android.content.Context
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import iammert.com.player.MediaSourceProvider
import com.google.android.exoplayer2.DefaultRenderersFactory.EXTENSION_RENDERER_MODE_PREFER
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.ExoPlayerFactory
import iammert.com.frekans.util.SingletonInstance
import iammert.com.player.PlayerListener
import iammert.com.player.PlayerState

/**
 * Created by mertsimsek on 12/12/2017.
 */
class PlayerWrapper private constructor(private val context: Context) : Player.DefaultEventListener() {

    private val mediaSourceProvider by lazy {
        MediaSourceProvider(context)
    }

    private val simpleExoPlayer by lazy {
        val trackSelectionFactory = AdaptiveTrackSelection.Factory(DefaultBandwidthMeter())
        val trackSelector = DefaultTrackSelector(trackSelectionFactory)
        val renderersFactory = DefaultRenderersFactory(context, null, EXTENSION_RENDERER_MODE_PREFER)
        ExoPlayerFactory.newSimpleInstance(renderersFactory, trackSelector)
    }

    private var playerListener: PlayerListener? = null

    init {
        simpleExoPlayer.playWhenReady = true
        simpleExoPlayer.addListener(this)
    }

    fun setListener(playerListener: PlayerListener) {
        this.playerListener = playerListener
    }

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        super.onPlayerStateChanged(playWhenReady, playbackState)
    }

    override fun onLoadingChanged(isLoading: Boolean) {
        super.onLoadingChanged(isLoading)
        playerListener?.onStateChanged(PlayerState.LOADING)

    }

    override fun onPlayerError(error: ExoPlaybackException?) {
        super.onPlayerError(error)
        playerListener?.onStateChanged(PlayerState.ERROR)
    }

    companion object : SingletonInstance<Context, PlayerWrapper>(::PlayerWrapper)
}