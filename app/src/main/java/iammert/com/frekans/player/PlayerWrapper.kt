package iammert.com.frekans.player

import android.content.Context
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import iammert.com.player.MediaSourceProvider
import com.google.android.exoplayer2.DefaultRenderersFactory.EXTENSION_RENDERER_MODE_PREFER
import com.google.android.exoplayer2.ExoPlayerFactory

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

    companion object {
        @Volatile private var INSTANCE: PlayerWrapper? = null

        fun getInstance(context: Context) =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: PlayerWrapper(context.applicationContext).also { INSTANCE = it }
                }
    }
}