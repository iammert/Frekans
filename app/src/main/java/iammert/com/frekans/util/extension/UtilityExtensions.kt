package iammert.com.frekans.util.extension

import iammert.com.frekans.BuildConfig

/**
 * Created by mertsimsek on 20/11/2017.
 */
inline fun debug(body: () -> Unit) {
    if (BuildConfig.DEBUG) body()
}