package iammert.com.frekans.util.delegates

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Created by mertsimsek on 07/12/2017.
 */
class SetContentView<in R : Activity, out DB : ViewDataBinding>(@LayoutRes private val layoutRes: Int) : ReadOnlyProperty<R, DB> {

    private var value: DB? = null

    override fun getValue(thisRef: R, property: KProperty<*>): DB {
        value = value ?: DataBindingUtil.setContentView(thisRef, layoutRes)
        return value!!
    }
}

fun <T : Activity, R : ViewDataBinding> contentView(@LayoutRes layoutRes: Int): SetContentView<T, R> {
    return SetContentView(layoutRes)
}