package iammert.com.base.extensions

import android.net.Uri

/**
 * Created by mertsimsek on 06/12/2017.
 */

fun String.toUri(): Uri {
    return Uri.parse(this)
}