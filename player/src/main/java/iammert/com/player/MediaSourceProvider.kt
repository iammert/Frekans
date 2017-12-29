package iammert.com.player

import com.google.android.exoplayer2.source.MediaSource

/**
 * Created by mertsimsek on 04/12/2017.
 */
interface MediaSourceProvider {
    fun getMediaSource(streamUrl: String, sourceType: SourceType): MediaSource

    companion object {
        const val FORMAT_MPEG = "mpeg"
        const val FORMAT_MP4A = "mp4a"
        const val PROTOCOL_SHOUTCAST = "shoutcast"
        const val PROTOCOL_ICECAST = "icecast"
        const val PROTOCOL_RTMP = "rtmp"
        const val PROTOCOL_HLS = "hls"
    }
}
