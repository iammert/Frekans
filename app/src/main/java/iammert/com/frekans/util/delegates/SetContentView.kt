package iammert.com.frekans.util.delegates

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import kotlin.reflect.KProperty

/**
 * Created by mertsimsek on 07/12/2017.
 */
class SetContentView<out DB : ViewDataBinding>(@LayoutRes private val layoutRes: Int) {

    private var value: DB? = null

    operator fun getValue(thisRef: Activity, property: KProperty<*>): DB {
        value = value ?: DataBindingUtil.setContentView(thisRef, layoutRes)
        return value!!
    }
}