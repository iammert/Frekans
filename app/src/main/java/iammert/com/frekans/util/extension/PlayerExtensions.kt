package iammert.com.frekans.util.extension

import iammert.com.data.remote.model.Stream
import iammert.com.player.MediaSourceProvider
import iammert.com.player.SourceType


/**
 * Created by mertsimsek on 06/12/2017.
 */
fun Stream?.sourceType(): SourceType {
    this?.protocol?.toLowerCase()?.let {
        if (it.contains(MediaSourceProvider.PROTOCOL_ICECAST) || it.contains(MediaSourceProvider.PROTOCOL_SHOUTCAST)) {
            return SourceType.DEFAULT
        }

        if (it.contains(MediaSourceProvider.PROTOCOL_HLS)) {
            return SourceType.HLS
        }
    }

    this?.format?.toLowerCase()?.let {
        if (it.contains(MediaSourceProvider.FORMAT_MP4A) || it.contains(MediaSourceProvider.FORMAT_MPEG)) {
            return SourceType.DEFAULT
        }
    }

    return SourceType.DEFAULT
}