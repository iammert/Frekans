package iammert.com.base.extensions

import iammert.com.base.BuildConfig


/**
 * Created by mertsimsek on 20/11/2017.
 */
inline fun debug(body: () -> Unit) {
    if (BuildConfig.DEBUG) body()
}