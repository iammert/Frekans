package iammert.com.player

import android.content.Context
import android.os.Handler
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util
import iammert.com.base.extensions.toUri
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by mertsimsek on 19/12/2017.
 */
@Singleton
class ExoPlayerSourceProvider @Inject constructor(context: Context) : MediaSourceProvider {
    private val handler = Handler()
    private val bandwidthMeter = DefaultBandwidthMeter()
    private val httpDataSourceFactory = DefaultHttpDataSourceFactory(Util.getUserAgent(context, context.getString(R.string.app_name)), bandwidthMeter)
    private val defaultDataSourceFactory = DefaultDataSourceFactory(context, bandwidthMeter, httpDataSourceFactory)

    override fun getMediaSource(streamUrl: String, sourceType: SourceType): MediaSource {
        return when (sourceType) {
            SourceType.HLS ->
                HlsMediaSource(
                        streamUrl.toUri(),
                        defaultDataSourceFactory,
                        handler,
                        null)

            SourceType.DEFAULT ->
                ExtractorMediaSource(
                        streamUrl.toUri(),
                        defaultDataSourceFactory,
                        DefaultExtractorsFactory(),
                        handler,
                        null)
        }
    }
}