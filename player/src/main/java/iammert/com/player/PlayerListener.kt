package iammert.com.player

/**
 * Created by mertsimsek on 06/12/2017.
 */
interface PlayerListener {
    fun onLoading()

    fun onPlaying()

    fun onIdle()

    fun onError()
}
