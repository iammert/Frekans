package iammert.com.frekans.util.extension

import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.TranslateAnimation

/**
 * Created by mertsimsek on 03/01/18.
 */
inline fun <T : View> T.afterMeasured(crossinline f: T.() -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            if (measuredWidth > 0 && measuredHeight > 0) {
                viewTreeObserver.removeOnGlobalLayoutListener(this)
                f()
            }
        }
    })
}

fun View.translateUp(onlyIfNotVisible: Boolean = false) {
    if (onlyIfNotVisible && View.VISIBLE == visibility) {
        return
    }
    visibility = View.VISIBLE
    afterMeasured {
        val translateAnimation = TranslateAnimation(0f, 0f, height.toFloat(), 0f)
        translateAnimation.apply {
            duration = 300
            fillAfter = true
            startAnimation(this)
        }
    }
}