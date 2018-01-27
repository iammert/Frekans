package iammert.com.frekans.util.extension

import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation

/**
 * Created by mertsimsek on 05/01/2018.
 */

class AnimationListenerDelegate : Animation.AnimationListener {

    private var _onAnimationRepeat: ((animation: Animation?) -> Unit)? = null
    private var _onAnimationEnd: ((animation: Animation?) -> Unit)? = null
    private var _onAnimationStart: ((animation: Animation?) -> Unit)? = null

    override fun onAnimationRepeat(p0: Animation?) {
        _onAnimationRepeat?.invoke(p0)
    }

    override fun onAnimationEnd(p0: Animation?) {
        _onAnimationEnd?.invoke(p0)
    }

    override fun onAnimationStart(p0: Animation?) {
        _onAnimationStart?.invoke(p0)
    }

    fun onAnimationEnd(animaton: (animation: Animation?) -> Unit) {
        _onAnimationEnd = animaton
    }
}

inline fun Animation.setAnimationListener(func: AnimationListenerDelegate.() -> Unit): Animation {
    val listener = AnimationListenerDelegate()
    listener.func()
    setAnimationListener(listener)
    return this
}

fun View.translateUp(onlyIfNotVisible: Boolean = false, func: AnimationListenerDelegate.() -> Unit) {
    if (onlyIfNotVisible && View.VISIBLE == visibility) return
    TranslateAnimation(0f, 0f, height.toFloat(), 0f)
            .apply {
                visibility = View.VISIBLE
                duration = 200
                fillAfter = true
                setAnimationListener(func)
                startAnimation(this)
            }
}