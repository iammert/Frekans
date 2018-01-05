package iammert.com.frekans.util.extension

import android.animation.Animator
import android.view.View
import android.view.ViewPropertyAnimator

/**
 * Created by mertsimsek on 05/01/2018.
 */

class AnimatorListenerDelegate : Animator.AnimatorListener {

    private var _onAnimationRepeat: ((animation: Animator?) -> Unit)? = null
    private var _onAnimationEnd: ((animation: Animator?) -> Unit)? = null
    private var _onAnimationStart: ((animation: Animator?) -> Unit)? = null
    private var _onAnimationCancel: ((animation: Animator?) -> Unit)? = null

    override fun onAnimationRepeat(p0: Animator?) {
        _onAnimationRepeat?.invoke(p0)
    }

    override fun onAnimationEnd(p0: Animator?) {
        _onAnimationEnd?.invoke(p0)
    }

    override fun onAnimationStart(p0: Animator?) {
        _onAnimationStart?.invoke(p0)
    }

    override fun onAnimationCancel(p0: Animator?) {
        _onAnimationCancel?.invoke(p0)
    }

    fun onAnimationEnd(animator: (animation: Animator?) -> Unit) {
        _onAnimationEnd = animator
    }

    fun onAnimationStart(animator: (animation: Animator?) -> Unit) {
        _onAnimationStart = animator
    }
}

inline fun ViewPropertyAnimator.setListener(func: AnimatorListenerDelegate.() -> Unit): ViewPropertyAnimator {
    val listener = AnimatorListenerDelegate()
    listener.func()
    setListener(listener)
    return this
}

fun View.translateUp(onlyIfNotVisible: Boolean = false, func: AnimatorListenerDelegate.() -> Unit) {
    if (onlyIfNotVisible && View.VISIBLE == visibility) return
    animate().translationY(height.toFloat()).setDuration(200).setListener(func).start()
}