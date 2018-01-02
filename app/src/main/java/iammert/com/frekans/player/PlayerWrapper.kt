package iammert.com.frekans.player

import android.content.Context
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.DefaultRenderersFactory.EXTENSION_RENDERER_MODE_PREFER
import iammert.com.data.remote.model.Stream
import iammert.com.frekans.util.extension.sourceType
import iammert.com.player.MediaSourceProvider
import iammert.com.player.PlayerState
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by mertsimsek on 12/12/2017.
 */
@Singleton
class PlayerWrapper @Inject constructor(val context: Context,
                                        val mediaSourceProvider: MediaSourceProvider) :
        Player.DefaultEventListener() {

    val playerStateSubject = BehaviorSubject.create<PlayerState>()

    private val simpleExoPlayer by lazy {
        val trackSelectionFactory = AdaptiveTrackSelection.Factory(DefaultBandwidthMeter())
        val trackSelector = DefaultTrackSelector(trackSelectionFactory)
        val renderersFactory = DefaultRenderersFactory(context, null, EXTENSION_RENDERER_MODE_PREFER)
        ExoPlayerFactory.newSimpleInstance(renderersFactory, trackSelector)
    }

    init {
        simpleExoPlayer.playWhenReady = true
        simpleExoPlayer.addListener(this)
    }

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        super.onPlayerStateChanged(playWhenReady, playbackState)
        when (playbackState) {
            Player.STATE_READY -> playerStateSubject.onNext(PlayerState.PLAYING)
            Player.STATE_IDLE -> playerStateSubject.onNext(PlayerState.IDLE)
        }
    }

    override fun onLoadingChanged(isLoading: Boolean) {
        super.onLoadingChanged(isLoading)
        playerStateSubject.onNext(PlayerState.LOADING)
    }

    override fun onPlayerError(error: ExoPlaybackException?) {
        super.onPlayerError(error)
        playerStateSubject.onNext(PlayerState.ERROR)
    }

    fun start(stream: Stream) {
        val mediaSource = mediaSourceProvider.getMediaSource(stream?.url ?: "", stream.sourceType())
        simpleExoPlayer.prepare(mediaSource)
    }

    fun stop() {
        simpleExoPlayer.stop()
    }
}